package com.business.rrhh.module.company.dao.mapper;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.module.company.model.business.Company;

public class CompanyMapper {

    public static CompanyEntity mapToEntity(Company company) {

        return CompanyEntity.builder()
                .id(company.getId())
                .brandName(company.getBrandName())
                .status(company.getStatus())
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
                .status(companyEntity.getStatus())
                .address(companyEntity.getAddress())
                .email(companyEntity.getEmail())
                .ruc(companyEntity.getRuc())
                .phone(companyEntity.getPhone())
                .build();

    }
}
