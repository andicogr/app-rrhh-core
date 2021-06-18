package com.business.rrhh.module.employee.controller.mapper;

import com.business.rrhh.module.afp.model.api.AfpResponse;
import com.business.rrhh.module.afp.model.business.Afp;

import java.util.Objects;

public class AfpMapper {

    public static AfpResponse mapToResponse(Afp business) {

        if (Objects.isNull(business)) {
            return null;
        }

        return AfpResponse.builder()
                .id(business.getId())
                .name(business.getName())
                .build();

    }

}
