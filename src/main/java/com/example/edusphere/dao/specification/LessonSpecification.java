package com.example.edusphere.dao.specification;

import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.dao.entity.Teacher;
import com.example.edusphere.model.filter.LessonFilter;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class LessonSpecification extends PatternSpecification<Lesson> {

    public enum FetchType {
        TEACHER, SUBJECT, GROUP
    }

    public Specification<Lesson> filterByCriteria(LessonFilter criteria) {
        return (root, query, builder) -> {
            Specification<Lesson> spec = Specification
                    .where(byDate(criteria.getFromDate(), criteria.getToDate()))
                    .and(byTeacherFullName(criteria.getTeacherFullName()))
                    .and(bySubjectName(criteria.getSubjectName()))
                    .and(byGroupName(criteria.getGroupName()));

            return spec.and(fetch(criteria.getFetches())).toPredicate(root, query, builder);
        };
    }

    private Specification<Lesson> fetch(FetchType... fetches) {
        return (root, query, cb) -> {
            for (FetchType fetch : fetches) {
                switch (fetch) {
                    case TEACHER:
                        if (!alreadyFetched(root, "teacher")) {
                            root.fetch("teacher", JoinType.INNER);
                        }
                    case SUBJECT:
                        if (!alreadyFetched(root, "subject")) {
                            root.fetch("subject", JoinType.INNER);
                        }
                    case GROUP:
                        if (!alreadyFetched(root, "leader")) {
                            root.fetch("leader", JoinType.INNER);
                        }
                }
            }

            return cb.conjunction();
        };
    }

    @Override
    protected boolean alreadyFetched(From<?, ?> from, String attribute) {
        return super.alreadyFetched(from, attribute);
    }

    private Specification<Lesson> byDate(Instant from, Instant to) {
        return (root, query, cb) -> {
            if (from == null && to == null) {
                return cb.conjunction();
            }

            List<Predicate> predicates = new ArrayList<>();

            if (from != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("date"), from));
            }

            if (to != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("date"), to));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private Specification<Lesson> byTeacherFullName(String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return cb.conjunction();
            }

            Join<Lesson, Teacher> join = root.join("teacher", JoinType.INNER);
            return cb.or(
                    cb.like(cb.lower(join.get("firstName")), value.toLowerCase() + "%"),
                    cb.like(cb.lower(join.get("middleName")), value.toLowerCase() + "%"),
                    cb.like(cb.lower(join.get("lastName")), value.toLowerCase() + "%")
            );
        };
    }

    private Specification<Lesson> bySubjectName(String value) {
        return (root, query, cb) -> {
            Join<Lesson, Subject> subjectJoin = root.join("subject", JoinType.INNER);
            return cb.like(subjectJoin.get("name"), "%" + value + "%");
        };
    }

    private Specification<Lesson> byGroupName(String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return cb.conjunction();
            }

            Join<Lesson, Group> groupJoin = root.join("group", JoinType.INNER);
            return cb.like(cb.lower(groupJoin.get("name")), value.toLowerCase() + "%");
        };
    }
}
