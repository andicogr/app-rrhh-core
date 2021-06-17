package com.business.rrhh.module.afp.dao.mapper;

import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.afp.model.business.AfpCommission;
import com.business.rrhh.module.afp.model.database.AfpCommissionEntity;
import com.business.rrhh.util.model.business.Month;

public class AfpCommissionMapper {

    public static AfpCommission mapToBusiness(AfpCommissionEntity entity) {

        return AfpCommission.builder()
                .id(entity.getId())
                .fiscalYear(FiscalYearMapper.mapToBusiness(entity.getFiscalYear()))
                .month(Month.of(entity.getMonth()))
                .afp(AfpMapper.mapToBusiness(entity.getAfp()))
                .commission(entity.getCommission())
                .contribution(entity.getContribution())
                .insurance(entity.getInsurance())
                .maximumRemuneration(entity.getMaximumRemuneration())
                .type(entity.getType())
                .build();

    }

    public static AfpCommissionEntity mapToEntity(AfpCommission business) {

        return AfpCommissionEntity.builder()
                .id(business.getId())
                .fiscalYear(FiscalYearMapper.mapToEntity(business.getFiscalYear()))
                .month(business.getMonth().getCode())
                .afp(AfpMapper.mapToEntity(business.getAfp()))
                .commission(business.getCommission())
                .contribution(business.getContribution())
                .insurance(business.getInsurance())
                .maximumRemuneration(business.getMaximumRemuneration())
                .type(business.getType())
                .build();

    }

    public static AfpCommissionEntity mapToEntity(Afp afp) {

        return AfpCommissionEntity.builder()
                .afp(AfpMapper.mapToEntity(afp))
                .build();

    }

}
