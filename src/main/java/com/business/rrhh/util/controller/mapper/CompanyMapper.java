package com.business.rrhh.util.controller.mapper;

import com.business.rrhh.util.model.api.CompanyRequest;
import com.business.rrhh.util.model.api.CompanyResponse;
import com.business.rrhh.util.model.business.Company;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompanyMapper {

    public static List<CompanyResponse> mapToResponse(List<Company> companies) {

        if (Objects.isNull(companies)) {
            return null;
        }

        return companies.stream()
                .map(CompanyMapper::mapToResponse)
                .collect(Collectors.toList());

    }

    public static CompanyResponse mapToResponse(Company company) {

        if (Objects.isNull(company)) {
            return null;
        }

        return CompanyResponse.builder()
                .id(company.getId())
                .brandName(company.getBrandName())
                .build();

    }

    public static Company mapToCompany(Integer companyId) {

        return Company.builder()
                .id(companyId)
                .build();

    }

    public static Company mapToCompany(CompanyRequest companyRequest) {

        if (Objects.isNull(companyRequest)) {
            return null;
        }

        return Company.builder()
                .id(companyRequest.getId())
                .build();

    }

    public static List<Company> mapToCompany(List<CompanyRequest> companiesRequest) {

        if (Objects.isNull(companiesRequest)) {
            return null;
        }

        return companiesRequest.stream()
                .map(CompanyMapper::mapToCompany)
                .collect(Collectors.toList());

    }

}
