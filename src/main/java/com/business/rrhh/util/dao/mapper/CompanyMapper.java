package com.business.rrhh.util.dao.mapper;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.util.model.business.Company;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CompanyMapper {

    public static Set<CompanyEntity> mapToEntity(List<Company> companies) {

        if (Objects.isNull(companies)) {
            return null;
        }

        return companies.stream()
                .map(CompanyMapper::mapToEntity)
                .collect(Collectors.toSet());

    }

    public static CompanyEntity mapToEntity(Company company) {

        if (Objects.isNull(company)) {
            return null;
        }

        return CompanyEntity.builder()
                .id(company.getId())
                .brandName(company.getBrandName())
                .build();

    }

    public static Company mapToCompany(Integer companyId){

        return Company.builder()
                .id(companyId)
                .build();

    }

    public static Company mapToCompany(CompanyEntity companyEntity){

        return Company.builder()
                .id(companyEntity.getId())
                .brandName(companyEntity.getBrandName())
                .build();

    }

    public static List<Company> mapToCompany(Set<CompanyEntity> companyEntity){

        if (Objects.isNull(companyEntity)) {
            return null;
        }

        return companyEntity.stream()
                .map(CompanyMapper::mapToCompany)
                .collect(Collectors.toList());

    }

}
