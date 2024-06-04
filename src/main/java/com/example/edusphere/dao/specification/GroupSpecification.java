package com.example.edusphere.dao.specification;

import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dao.entity.Teacher;
import com.example.edusphere.model.filter.GroupFilter;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class GroupSpecification extends PatternSpecification<Group> {

    public enum FetchType {
        STUDENT, CURATOR, LEADER
    }

    public Specification<Group> filterByCriteria(GroupFilter criteria) {
        return (root, query, builder) -> {
            Specification<Group> spec = Specification
                    .where(byName(criteria.getName()))
                    .and(byCourse(criteria.getCourse()))
                    .and(byLeaderFullName(criteria.getLeaderFullName()))
                    .and(byCuratorFullName(criteria.getCuratorFullName()));

            return spec.and(fetch(criteria.getFetches())).toPredicate(root, query, builder);
        };
    }

    private Specification<Group> fetch(FetchType... fetches) {
        return (root, query, cb) -> {
            for (FetchType fetch : fetches) {
                switch (fetch) {
                    case STUDENT -> {
                        if (!alreadyFetched(root, "students")) {
                            root.fetch("students", JoinType.INNER);
                        }
                    }
                    case CURATOR -> {
                        if (!alreadyFetched(root, "curator")) {
                            root.fetch("curator", JoinType.INNER);
                        }
                    }
                    case LEADER -> {
                        if (!alreadyFetched(root, "leader")) {
                            root.fetch("leader", JoinType.INNER);
                        }
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

    private Specification<Group> byName(String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return cb.conjunction();
            }

            return cb.like(cb.lower(root.get("name")), value.toLowerCase() + "%");
        };
    }

    private Specification<Group> byCourse(Integer course) {
        return (root, query, cb) -> {
            if (course == null) {
                return cb.conjunction();
            }

            return cb.equal(root.get("course"), course);
        };
    }

    private Specification<Group> byLeaderFullName(String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return cb.conjunction();
            }

            Join<Group, Student> join = root.join("student", JoinType.INNER);
            return cb.or(
                    cb.like(cb.lower(join.get("firstName")), value.toLowerCase() + "%"),
                    cb.like(cb.lower(join.get("middleName")), value.toLowerCase() + "%"),
                    cb.like(cb.lower(join.get("lastName")), value.toLowerCase() + "%")
            );
        };
    }

    private Specification<Group> byCuratorFullName(String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return cb.conjunction();
            }

            Join<Group, Teacher> join = root.join("teacher", JoinType.INNER);
            return cb.or(
                    cb.like(cb.lower(join.get("firstName")), value.toLowerCase() + "%"),
                    cb.like(cb.lower(join.get("middleName")), value.toLowerCase() + "%"),
                    cb.like(cb.lower(join.get("lastName")), value.toLowerCase() + "%")
            );
        };
    }
}