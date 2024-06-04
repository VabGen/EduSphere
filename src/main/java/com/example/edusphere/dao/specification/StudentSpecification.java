package com.example.edusphere.dao.specification;

import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.model.enums.GenderType;
import com.example.edusphere.model.filter.StudentFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class StudentSpecification extends PatternSpecification<Student> {

    public enum FetchType {
        GROUP
    }

    public Specification<Student> filterByCriteria(StudentFilter criteria) {
        return (root, query, builder) -> {
            Specification<Student> spec = Specification
                    .where(byFullName(builder, root, criteria.getFullName()))
                    .and(byGender(criteria.getGenderType()))
                    .and(byDismissed(criteria.isDismissed()));

            return spec.and(fetch(criteria.getFetches())).toPredicate(root, query, builder);
        };
    }

    private Specification<Student> fetch(FetchType... fetches) {
        return (root, query, cb) -> {
            for (FetchType fetch : fetches) {
                if (fetch.equals(FetchType.GROUP)) {
                    if (!alreadyFetched(root, "group")) {
                        root.fetch("group", JoinType.INNER);
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

    @Override
    protected Specification<Student> byFullName(CriteriaBuilder cb, Root<Student> root, String value) {
        return super.byFullName(cb, root, value);
    }

    private Specification<Student> byGender(GenderType genderType) {
        return (root, query, cb) -> {
            if (genderType != null) {
                return cb.equal(root.get("gender"), genderType);
            }

            return cb.conjunction();
        };
    }

    private Specification<Student> byDismissed(Boolean dismissed) {
        return (root, query, cb) -> {
            if (dismissed != null) {
                return cb.equal(root.get("dismissed"), dismissed);
            }

            return cb.conjunction();
        };
    }
}

