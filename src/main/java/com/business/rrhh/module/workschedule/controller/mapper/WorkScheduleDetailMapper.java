package com.business.rrhh.module.workschedule.controller.mapper;

import com.business.rrhh.module.workschedule.model.api.WorkScheduleDetailCreateRequest;
import com.business.rrhh.module.workschedule.model.api.WorkScheduleDetailResponse;
import com.business.rrhh.module.workschedule.model.api.WorkScheduleDetailUpdateRequest;
import com.business.rrhh.module.workschedule.model.business.WorkScheduleDetail;

public class WorkScheduleDetailMapper {

    public static WorkScheduleDetail mapToBusiness(Integer parentId, WorkScheduleDetailCreateRequest createRequest) {

        return WorkScheduleDetail.builder()
                .openingTime(createRequest.getOpeningTime())
                .departureTime(createRequest.getDepartureTime())
                .workSchedule(WorkScheduleMapper.mapToBusiness(parentId))
                .dayOfWeek(createRequest.getDayOfWeek())
                .build();

    }

    public static WorkScheduleDetail mapToBusiness(Integer parentId, Integer id, WorkScheduleDetailUpdateRequest updateRequest) {

        return WorkScheduleDetail.builder()
                .id(id)
                .openingTime(updateRequest.getOpeningTime())
                .departureTime(updateRequest.getDepartureTime())
                .workSchedule(WorkScheduleMapper.mapToBusiness(parentId))
                .dayOfWeek(updateRequest.getDayOfWeek())
                .build();

    }

    public static WorkScheduleDetailResponse mapToResponse(WorkScheduleDetail business) {

        return WorkScheduleDetailResponse.builder()
                .id(business.getId())
                .openingTime(business.getOpeningTime())
                .departureTime(business.getDepartureTime())
                .dayOfWeek(business.getDayOfWeek())
                .build();

    }

}
