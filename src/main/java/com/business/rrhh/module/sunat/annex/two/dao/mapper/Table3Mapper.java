package com.business.rrhh.module.sunat.annex.two.dao.mapper;

import com.business.rrhh.module.sunat.annex.two.model.business.Table3;
import com.business.rrhh.module.sunat.annex.two.model.database.Table3Entity;
import com.business.rrhh.util.dao.mapper.CompanyMapper;

import java.util.Objects;

public class Table3Mapper {

    public static Table3Entity mapToEntity(Table3 table3) {

        if (Objects.isNull(table3)) {
            return null;
        }

        Table3Entity table3Entity = new Table3Entity();

        table3Entity.setId(table3.getId());
        table3Entity.setCode(table3.getCode());
        table3Entity.setSunatCode(table3.getSunatCode());
        table3Entity.setDescription(table3.getDescription());
        table3Entity.setActive(table3.getActive());
        table3Entity.setCompany(CompanyMapper.mapToEntity(table3.getCompany()));

        return table3Entity;

    }

    public static Table3 mapToBusiness(Table3Entity entity) {

        return Table3.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .sunatCode(entity.getSunatCode())
                .description(entity.getDescription())
                .active(entity.getActive())
                .company(CompanyMapper.mapToCompany(entity.getCompany()))
                .build();

    }

}
