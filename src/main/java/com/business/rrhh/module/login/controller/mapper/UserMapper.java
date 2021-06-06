package com.business.rrhh.module.login.controller.mapper;

import com.business.rrhh.module.login.model.api.*;
import com.business.rrhh.module.login.model.business.Company;
import com.business.rrhh.module.login.model.business.User;

import java.util.Objects;

public class UserMapper {

    public static User mapToUser(Integer id, UserUpdateRequest userRequest) {

        Company company = null;

        if (Objects.nonNull(userRequest.getCompany())) {
            company = Company.builder()
                    .id(userRequest.getCompany().getId())
                    .build();
        }

        return User.builder()
                .id(id)
                .password(userRequest.getPassword())
                .status(userRequest.getStatus())
                .company(company)
                .build();

    }

    public static User mapToUser(UserRequest userRequest) {

        Company company = Company.builder()
                .id(userRequest.getCompany().getId())
                .build();

        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .status(userRequest.getStatus())
                .company(company)
                .build();

    }

    public static User mapToUser(UserSearchRequest userSearchRequest) {

        Company company = null;

        if (Objects.nonNull(userSearchRequest.getCompanyId())) {
            company = Company.builder()
                    .id(userSearchRequest.getCompanyId())
                    .build();
        }

        return User.builder()
                .username(userSearchRequest.getUsername())
                .status(userSearchRequest.getStatus())
                .company(company)
                .build();

    }

    public static UserResponse mapToResponse(User user) {

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setStatus(user.getStatus());

        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setId(user.getCompany().getId());
        companyResponse.setBrandName(user.getCompany().getBrandName());

        userResponse.setCompany(companyResponse);

        return userResponse;

    }

    public static UserSearchResponse mapToResponseSearch(User user) {

        UserSearchResponse response = new UserSearchResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setStatus(user.getStatus());

        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setId(user.getCompany().getId());
        companyResponse.setBrandName(user.getCompany().getBrandName());
        response.setCompany(companyResponse);

        return response;

    }

}
