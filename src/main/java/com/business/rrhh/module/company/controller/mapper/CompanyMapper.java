package com.business.rrhh.module.company.controller.mapper;

import com.business.rrhh.module.company.model.api.CompanyResponseSearch;
import com.business.rrhh.module.company.model.api.CompanySearchRequest;
import com.business.rrhh.module.login.model.business.Company;

public class CompanyMapper {

    public static Company mapToCompany(CompanySearchRequest companySearchRequest) {

        return Company.builder()
                .brandName(companySearchRequest.getBrandName())
                .status(companySearchRequest.getStatus())
                .ruc(companySearchRequest.getRuc())
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
}
