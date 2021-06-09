package com.business.rrhh.module.login.controller.mapper;

import com.business.rrhh.module.login.model.api.*;
import com.business.rrhh.module.login.model.business.Company;
import com.business.rrhh.module.login.model.business.User;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserMapper {

    public static User mapToUser(Integer id, UserUpdateRequest userRequest) {

        List<Company> companies = null;

        if (Objects.nonNull(userRequest.getCompanies())) {

            companies = userRequest.getCompanies().stream()
                    .map(company -> Company.builder().id(company.getId()).build())
                    .collect(Collectors.toList());

        }

        return User.builder()
                .id(id)
                .password(userRequest.getPassword())
                .status(userRequest.getStatus())
                .companies(companies)
                .build();

    }

    public static User mapToUser(UserRequest userRequest) {

        List<Company> companies = null;

        if (Objects.nonNull(userRequest.getCompanies())) {

            companies = userRequest.getCompanies().stream()
                    .map(company -> Company.builder().id(company.getId()).build())
                    .collect(Collectors.toList());

        }

        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .status(userRequest.getStatus())
                .companies(companies)
                .build();

    }

    public static User mapToUser(UserByPageSearchRequest userSearchRequest) {

        List<Company> companies = null;

        if (Objects.nonNull(userSearchRequest.getCompanyIds())) {

            companies = Arrays.stream(userSearchRequest.getCompanyIds())
                    .map(id -> Company.builder().id(id).build())
                    .collect(Collectors.toList());

        }

        return User.builder()
                .username(userSearchRequest.getUsername())
                .status(userSearchRequest.getStatus())
                .companies(companies)
                .build();

    }

    public static UserResponse mapToResponse(User user) {

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setStatus(user.getStatus());

        List<CompanyResponse> companyResponseList = user.getCompanies().stream()
                .map(company -> {
                    CompanyResponse companyResponse = new CompanyResponse();
                    companyResponse.setId(company.getId());
                    companyResponse.setBrandName(company.getBrandName());

                    return companyResponse;
                })
                .collect(Collectors.toList());


        userResponse.setCompanies(companyResponseList);

        return userResponse;

    }

    public static UserSearchResponse mapToResponseSearch(User user) {

        UserSearchResponse response = new UserSearchResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setStatus(user.getStatus());

        List<CompanyResponse> companyResponseList = user.getCompanies().stream()
                .map(company -> {
                    CompanyResponse companyResponse = new CompanyResponse();
                    companyResponse.setId(company.getId());
                    companyResponse.setBrandName(company.getBrandName());

                    return companyResponse;
                })
                .collect(Collectors.toList());

        response.setCompanies(companyResponseList);

        return response;

    }

}
