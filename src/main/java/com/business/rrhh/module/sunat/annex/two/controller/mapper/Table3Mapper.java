package com.business.rrhh.module.sunat.annex.two.controller.mapper;

import com.business.rrhh.module.sunat.annex.two.model.api.Table3ByPageSearchRequest;
import com.business.rrhh.module.sunat.annex.two.model.api.Table3SearchResponse;
import com.business.rrhh.module.sunat.annex.two.model.business.Table3;
import com.business.rrhh.util.controller.mapper.CompanyMapper;

public class Table3Mapper {

    public static Table3SearchResponse mapToResponseSearch(Table3 table3){

        return Table3SearchResponse.builder()
                .id(table3.getId())
                .code(table3.getCode())
                .sunatCode(table3.getSunatCode())
                .description(table3.getDescription())
                .status(table3.getStatus())
                .company(CompanyMapper.mapToResponse(table3.getCompany()))
                .build();
    }

    public static Table3 mapToTable3(Table3ByPageSearchRequest searchByPage) {

        return Table3.builder()
                .code(searchByPage.getCode())
                .sunatCode(searchByPage.getSunatCode())
                .description(searchByPage.getDescription())
                .status(searchByPage.getStatus())
                .company(CompanyMapper.mapToCompany(searchByPage.getCompanyId()))
                .build();

    }
}
