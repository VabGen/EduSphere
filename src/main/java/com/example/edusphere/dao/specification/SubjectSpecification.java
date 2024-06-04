package com.example.edusphere.dao.specification;

import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.model.filter.SubjectFilter;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SubjectSpecification extends PatternSpecification<Subject> {

    public enum FetchType {
        LESSON
    }

    public Specification<Subject> filterByCriteria(SubjectFilter criteria) {
        return (root, query, builder) -> {
            Specification<Subject> spec = Specification
                    .where(byName(criteria.getName()));

            return spec.and(fetch(criteria.getFetches())).toPredicate(root, query, builder);
        };
    }

    private Specification<Subject> fetch(FetchType... fetches) {
        return (root, query, cb) -> {
            for (FetchType fetch : fetches) {
                if (fetch.equals(FetchType.LESSON)) {
                    if (!alreadyFetched(root, "lessons")) {
                        root.fetch("lessons", JoinType.INNER);
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

    private Specification<Subject> byName(String name) {
        return (root, query, cb) -> {
            if (name == null) {
                cb.conjunction();
            }

            return cb.like(root.get("name"), "%" + name + "%");
        };
    }
}