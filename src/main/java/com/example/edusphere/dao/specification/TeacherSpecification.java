package com.example.edusphere.dao.specification;

import com.example.edusphere.dao.entity.Teacher;
import com.example.edusphere.model.enums.GenderType;
import com.example.edusphere.model.filter.TeacherFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TeacherSpecification extends PatternSpecification<Teacher> {

    public enum FetchType {
        GROUP
    }

    public Specification<Teacher> filterByCriteria(TeacherFilter criteria) {
        return (root, query, builder) -> {
            Specification<Teacher> spec = Specification.where(byFullName(builder, root, criteria.getFullName()))
                    .and(byGender(criteria.getGenderType()))
                    .and(byDismissed(criteria.isDismissed()));

            return spec.and(fetch(criteria.getFetches())).toPredicate(root, query, builder);
        };
    }

    private Specification<Teacher> fetch(FetchType... fetches) {
        return (root, query, cb) -> {
            for (FetchType fetch : fetches) {
                if (fetch.equals(FetchType.GROUP)) {
                    if (!alreadyFetched(root, "groups")) {
                        root.fetch("groups", JoinType.INNER);
                    }
                }
            }

            return cb.conjunction();
        };
    }

    @Override
    protected Specification<Teacher> byFullName(CriteriaBuilder cb, Root<Teacher> root, String value) {
        return super.byFullName(cb, root, value);
    }

    @Override
    protected boolean alreadyFetched(From<?, ?> from, String attribute) {
        return super.alreadyFetched(from, attribute);
    }

    private Specification<Teacher> byGender(GenderType genderType) {
        return (root, query, cb) -> {
            if (genderType == null) {
                return cb.conjunction();
            }

            return cb.equal(root.get("gender"), genderType);
        };
    }

    private Specification<Teacher> byDismissed(boolean dismissed) {
        return (root, query, cb) -> {
            if (dismissed) {
                return cb.isTrue(root.get("dismissed"));
            } else {
                return cb.isFalse(root.get("dismissed"));
            }
        };
    }
}