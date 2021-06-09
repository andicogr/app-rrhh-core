package com.business.rrhh.module.company.controller.mapper;

import com.business.rrhh.module.company.model.api.*;
import com.business.rrhh.module.company.model.business.Company;

public class CompanyMapper {

    public static Company mapToCompany(CompanyByPageSearchRequest companySearchRequest) {

        return Company.builder()
                .brandName(companySearchRequest.getBrandName())
                .status(companySearchRequest.getStatus())
                .ruc(companySearchRequest.getRuc())
                .build();

    }

    public static Company mapToCompany(CompanyRequest companyRequest) {

        return Company.builder()
                .brandName(companyRequest.getBrandName())
                .status(companyRequest.getStatus())
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
        responseSearch.setStatus(company.getStatus());

        return responseSearch;

    }

    public static CompanyResponse mapToResponse(Company company) {

        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setId(company.getId());
        companyResponse.setAddress(company.getAddress());
        companyResponse.setBrandName(company.getBrandName());
        companyResponse.setRuc(company.getRuc());
        companyResponse.setStatus(company.getStatus());
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
