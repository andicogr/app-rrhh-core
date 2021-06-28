package com.business.rrhh.module.user.dao.mapper;

import com.business.rrhh.module.user.model.business.User;
import com.business.rrhh.module.user.model.database.UserEntity;
import com.business.rrhh.module.user.state.UserStates;
import com.business.rrhh.util.dao.mapper.CompanyMapper;

public class UserMapper {

    public static User mapToBusiness(UserEntity entity) {

        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .state(UserStates.getByCode(entity.getState()).buildState())
                .companies(CompanyMapper.mapToCompany(entity.getCompanies()))
                .build();

    }

    public static UserEntity mapToEntity(User user) {

        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .state(user.getState() != null ? user.getState().getCode() : null)
                .companies(CompanyMapper.mapToEntity(user.getCompanies()))
                .build();

    }

}
