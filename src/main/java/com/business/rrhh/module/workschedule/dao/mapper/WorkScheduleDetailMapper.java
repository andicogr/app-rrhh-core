package com.business.rrhh.module.workschedule.dao.mapper;

import com.business.rrhh.module.workschedule.model.business.WorkScheduleDetail;
import com.business.rrhh.module.workschedule.model.database.WorkScheduleDetailEntity;

public class WorkScheduleDetailMapper {

    public static WorkScheduleDetail mapToBusiness(WorkScheduleDetailEntity entity) {

        return WorkScheduleDetail.builder()
                .id(entity.getId())
                .dayOfWeek(entity.getDayOfWeek())
                .workSchedule(WorkScheduleMapper.mapToBusiness(entity.getWorkSchedule()))
                .departureTime(entity.getDepartureTime())
                .workTime(entity.getWorkTime())
                .openingTime(entity.getOpeningTime())
                .build();

    }

    public static WorkScheduleDetailEntity mapToEntity(WorkScheduleDetail business) {

        return WorkScheduleDetailEntity.builder()
                .id(business.getId())
                .dayOfWeek(business.getDayOfWeek())
                .workSchedule(WorkScheduleMapper.mapToEntity(business.getWorkSchedule()))
                .departureTime(business.getDepartureTime())
                .workTime(business.getWorkTime())
                .openingTime(business.getOpeningTime())
                .build();

    }


}
