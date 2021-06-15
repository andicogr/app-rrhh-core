package com.business.rrhh.module.workschedule.dao.mapper;

import com.business.rrhh.module.workschedule.model.business.WorkSchedule;
import com.business.rrhh.module.workschedule.model.database.WorkScheduleEntity;
import com.business.rrhh.util.dao.mapper.CompanyMapper;

import java.util.stream.Collectors;

public class WorkScheduleMapper {

    public static WorkScheduleEntity mapToEntity(WorkSchedule business) {

        return WorkScheduleEntity.builder()
                .id(business.getId())
                .active(business.getActive())
                .company(CompanyMapper.mapToEntity(business.getCompany()))
                .departureTolerance(business.getDepartureTolerance())
                .name(business.getName())
                .openingTolerance(business.getOpeningTolerance())
                .build();

    }

    public static WorkSchedule mapToBusiness(WorkScheduleEntity entity) {

        return WorkSchedule.builder()
                .id(entity.getId())
                .active(entity.getActive())
                .company(CompanyMapper.mapToCompany(entity.getCompany()))
                .departureTolerance(entity.getDepartureTolerance())
                .name(entity.getName())
                .openingTolerance(entity.getOpeningTolerance())
                .build();

    }
}
