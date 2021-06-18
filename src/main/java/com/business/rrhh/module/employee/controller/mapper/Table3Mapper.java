package com.business.rrhh.module.employee.controller.mapper;

import com.business.rrhh.module.employee.model.api.employee.Table3Request;
import com.business.rrhh.module.sunat.annex.two.model.api.Table3Response;
import com.business.rrhh.module.sunat.annex.two.model.business.Table3;

public class Table3Mapper {

    public static Table3 mapToTable3(Table3Request request) {

        return Table3.builder()
                .id(request.getId())
                .build();

    }

    public static Table3Response mapToResponse(Table3 table3) {

        return Table3Response.builder()
                .id(table3.getId())
                .code(table3.getCode())
                .build();

    }

}
