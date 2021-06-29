package com.business.rrhh.module.company.dao.mapper;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.company.state.CompanyStates;

public class CompanyMapper {

    public static CompanyEntity mapToEntity(Company company) {

        return CompanyEntity.builder()
                .id(company.getId())
                .brandName(company.getBrandName())
                .state(company.getState() != null ? company.getState().getCode() : null)
                .address(company.getAddress())
                .email(company.getEmail())
                .ruc(company.getRuc())
                .phone(company.getPhone())
                .build();

    }

    public static Company mapToBusiness(CompanyEntity companyEntity) {

        return Company.builder()
                .id(companyEntity.getId())
                .brandName(companyEntity.getBrandName())
                .state(CompanyStates.getByCode(companyEntity.getState()).buildState())
                .address(companyEntity.getAddress())
                .email(companyEntity.getEmail())
                .ruc(companyEntity.getRuc())
                .phone(companyEntity.getPhone())
                .build();

    }
}
