package com.business.rrhh.module.user.controller.mapper;

import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.user.model.api.*;
import com.business.rrhh.module.user.model.business.User;
import com.business.rrhh.module.user.state.UserStates;
import com.business.rrhh.util.controller.mapper.CompanyMapper;
import com.business.rrhh.util.controller.mapper.StateMapper;
import com.business.rrhh.util.model.api.CompanyResponse;
import com.business.rrhh.util.model.business.State;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserMapper {

    public static User mapToUser(Integer id, UserUpdateRequest userRequest) {

        State state = null;

        if (Objects.nonNull(userRequest.getState())) {
            state = StateMapper.mapToState(userRequest.getState().getCode());
        }

        return User.builder()
                .id(id)
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .state(state)
                .companies(CompanyMapper.mapToCompany(userRequest.getCompanies()))
                .build();

    }

    public static User mapToUser(UserCreateRequest userRequest) {

        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .state(UserStates.getByCode(userRequest.getState().getCode()).buildState())
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

        State state = null;

        if (Objects.nonNull(userSearchRequest.getState())) {
            state = UserStates.getByCode(userSearchRequest.getState()).buildState();
        }

        return User.builder()
                .username(userSearchRequest.getUsername())
                .state(state)
                .companies(companies)
                .build();

    }

    public static UserResponse mapToResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .state(StateMapper.mapToResponse(user.getState()))
                .active(user.isActive())
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
        response.setState(StateMapper.mapToResponse(user.getState()));
        response.setCompanies(
                CompanyMapper.mapToResponse(user.getCompanies())
                        .stream()
                        .sorted(Comparator.comparing(CompanyResponse::getBrandName))
                        .collect(Collectors.toList())
        );

        return response;

    }

}
