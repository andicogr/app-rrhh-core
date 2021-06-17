package com.business.rrhh.module.afp.dao.mapper;

import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.afp.model.database.AfpEntity;

public class AfpMapper {

    public static AfpEntity mapToEntity(Afp business) {

        return AfpEntity.builder()
                .id(business.getId())
                .active(business.getActive())
                .name(business.getName())
                .build();

    }

    public static Afp mapToBusiness(AfpEntity entity) {

        return Afp.builder()
                .id(entity.getId())
                .active(entity.getActive())
                .name(entity.getName())
                .build();

    }

}
