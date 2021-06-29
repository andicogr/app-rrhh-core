package com.business.rrhh.module.company.controller.mapper;

import com.business.rrhh.module.company.model.api.*;
import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.company.state.CompanyStates;
import com.business.rrhh.util.controller.mapper.StateMapper;
import com.business.rrhh.util.model.business.State;

import java.util.Objects;

public class CompanyMapper {

    public static Company mapToCompany(CompanyByPageSearchRequest companySearchRequest) {

        State state = null;

        if (Objects.nonNull(companySearchRequest.getState())) {
            state = CompanyStates.getByCode(companySearchRequest.getState()).buildState();
        }

        return Company.builder()
                .brandName(companySearchRequest.getBrandName())
                .state(state)
                .ruc(companySearchRequest.getRuc())
                .build();

    }

    public static Company mapToCompany(CompanyCreateRequest companyRequest) {

        return Company.builder()
                .brandName(companyRequest.getBrandName())
                .ruc(companyRequest.getRuc())
                .phone(companyRequest.getPhone())
                .address(companyRequest.getAddress())
                .email(companyRequest.getEmail())
                .build();

    }

    public static CompanyResponseSearch mapToResponseSearch(Company company) {

        CompanyResponseSearch responseSearch = new CompanyResponseSearch();
        responseSearch.setId(company.getId());
        responseSearch.setAddress(company.getAddress());
        responseSearch.setRuc(company.getRuc());
        responseSearch.setBrandName(company.getBrandName());
        responseSearch.setState(StateMapper.mapToResponse(company.getState()));

        return responseSearch;

    }

    public static CompanyResponse mapToResponse(Company company) {

        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setId(company.getId());
        companyResponse.setAddress(company.getAddress());
        companyResponse.setBrandName(company.getBrandName());
        companyResponse.setRuc(company.getRuc());
        companyResponse.setState(StateMapper.mapToResponse(company.getState()));
        companyResponse.setPhone(company.getPhone());
        companyResponse.setEmail(company.getEmail());

        return companyResponse;

    }


    public static Company mapToCompany(Integer id, CompanyUpdateRequest companyUpdateRequest) {

        return Company.builder()
                .id(id)
                .brandName(companyUpdateRequest.getBrandName())
                .ruc(companyUpdateRequest.getRuc())
                .phone(companyUpdateRequest.getPhone())
                .address(companyUpdateRequest.getAddress())
                .email(companyUpdateRequest.getEmail())
                .build();

    }
}
