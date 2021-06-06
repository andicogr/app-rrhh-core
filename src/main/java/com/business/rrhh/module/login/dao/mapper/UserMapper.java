package com.business.rrhh.module.login.dao.mapper;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.module.login.model.business.Company;
import com.business.rrhh.module.login.model.business.User;
import com.business.rrhh.module.login.model.database.UserEntity;

import java.util.Objects;

public class UserMapper {

    public static User mapToBusiness(UserEntity entity) {

        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .status(entity.getStatus())
                .company(
                        Company.builder()
                                .id(entity.getCompany().getId())
                                .brandName(entity.getCompany().getBrandName())
                                .build()
                )
                .build();

    }

    public static UserEntity mapToEntity(User user) {

        CompanyEntity company = null;

        if (Objects.nonNull(user.getCompany())) {
            company = CompanyEntity.builder()
                    .id(user.getCompany().getId())
                    .build();
        }

        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .status(user.getStatus())
                .company(company)
                .build();

    }

}
