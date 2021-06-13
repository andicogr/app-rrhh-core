package com.business.rrhh.module.login.dao.mapper;

import com.business.rrhh.module.login.model.business.User;
import com.business.rrhh.module.login.model.database.UserEntity;
import com.business.rrhh.util.dao.mapper.CompanyMapper;

public class UserMapper {

    public static User mapToBusiness(UserEntity entity) {

        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .status(entity.getStatus())
                .companies(CompanyMapper.mapToCompany(entity.getCompanies()))
                .build();

    }

    public static UserEntity mapToEntity(User user) {


        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .status(user.getStatus())
                .companies(CompanyMapper.mapToEntity(user.getCompanies()))
                .build();

    }

}
