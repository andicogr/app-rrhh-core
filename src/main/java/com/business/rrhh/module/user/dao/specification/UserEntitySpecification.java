package com.business.rrhh.module.user.dao.specification;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.module.user.model.database.UserEntity;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor(staticName = "of")
public class UserEntitySpecification {

    private UserEntity user;

    public Specification<UserEntity> build() {

        return (root, criteriaQuery, criteriaBuilder) -> {

            criteriaQuery.distinct(true);

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotBlank(user.getUsername())) {
                predicates.add(criteriaBuilder.like(root.get("username"), "%" + user.getUsername() + "%"));
            }

            if (Objects.nonNull(user.getState()) && StringUtils.isNotBlank(user.getState())) {
                predicates.add(criteriaBuilder.equal(root.get("state"), user.getState()));
            }

            if (CollectionUtils.isNotEmpty(user.getCompanies())) {

                Join<Object, Object> companies = root.join("companies", JoinType.INNER);

                predicates.add(criteriaBuilder.isTrue(companies.get("id").in(user.getCompanies().stream().map(CompanyEntity::getId).collect(Collectors.toList()))));

            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }

}
