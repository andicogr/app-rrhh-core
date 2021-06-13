package com.business.rrhh.module.login.controller.mapper;

import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.login.model.api.*;
import com.business.rrhh.module.login.model.business.User;
import com.business.rrhh.util.controller.mapper.CompanyMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserMapper {

    public static User mapToUser(Integer id, UserUpdateRequest userRequest) {

        return User.builder()
                .id(id)
                .password(userRequest.getPassword())
                .status(userRequest.getStatus())
                .companies(CompanyMapper.mapToCompany(userRequest.getCompanies()))
                .build();

    }

    public static User mapToUser(UserRequest userRequest) {

        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .status(userRequest.getStatus())
                .companies(CompanyMapper.mapToCompany(userRequest.getCompanies()))
                .build();

    }

    public static User mapToUser(UserByPageSearchRequest userSearchRequest) {

        List<Company> companies = null;

        if (Objects.nonNull(userSearchRequest.getCompanyIds())) {

            companies = Arrays.stream(userSearchRequest.getCompanyIds())
                    .map(CompanyMapper::mapToCompany)
                    .collect(Collectors.toList());

        }

        return User.builder()
                .username(userSearchRequest.getUsername())
                .status(userSearchRequest.getStatus())
                .companies(companies)
                .build();

    }

    public static User mapToUser(LoginRequest loginRequest) {

        return User.builder()
                .username(loginRequest.getUsername())
                .password(loginRequest.getPassword())
                .build();

    }

    public static UserResponse mapToResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .status(user.getStatus())
                .companies(CompanyMapper.mapToResponse(user.getCompanies()))
                .build();

    }

    public static UserResponse mapToIdResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .build();


    }

    public static UserSearchResponse mapToResponseSearch(User user) {

        UserSearchResponse response = new UserSearchResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setStatus(user.getStatus());
        response.setCompanies(CompanyMapper.mapToResponse(user.getCompanies()));

        return response;

    }

}
