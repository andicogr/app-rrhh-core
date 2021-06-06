package com.business.rrhh.module.login.dao.mapper;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.module.login.model.business.Company;
import com.business.rrhh.module.login.model.business.User;
import com.business.rrhh.module.login.model.database.UserEntity;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static User mapToBusiness(UserEntity entity) {

        List<Company> companyList = entity.getCompanies().stream().map(companyEntity -> Company.builder()
                .id(companyEntity.getId())
                .brandName(companyEntity.getBrandName())
                .build()
        ).collect(Collectors.toList());

        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .status(entity.getStatus())
                .companies(companyList)
                .build();

    }

    public static UserEntity mapToEntity(User user) {

        Set<CompanyEntity> companyList = null;

        if (Objects.nonNull(user.getCompanies())) {

            companyList = user.getCompanies().stream()
                    .map(company -> CompanyEntity.builder().id(company.getId()).build())
                    .collect(Collectors.toSet());

        }

        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .status(user.getStatus())
                .companies(companyList)
                .build();

    }

}
