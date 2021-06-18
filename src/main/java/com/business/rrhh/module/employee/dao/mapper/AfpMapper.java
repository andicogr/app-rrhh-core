package com.business.rrhh.module.employee.dao.mapper;

import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.afp.model.database.AfpEntity;

import java.util.Objects;

public class AfpMapper {

    public static Afp mapToBusiness(AfpEntity entity) {

        if (Objects.isNull(entity)) {
            return null;
        }

        return Afp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

    }

    public static AfpEntity mapToEntity(Afp business) {

        if (Objects.isNull(business)) {
            return null;
        }

        return AfpEntity.builder()
                .id(business.getId())
                .build();

    }

}
