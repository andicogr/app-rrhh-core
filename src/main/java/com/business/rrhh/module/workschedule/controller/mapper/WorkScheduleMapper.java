package com.business.rrhh.module.workschedule.controller.mapper;

import com.business.rrhh.module.workschedule.model.api.*;
import com.business.rrhh.module.workschedule.model.business.WorkSchedule;
import com.business.rrhh.util.controller.mapper.CompanyMapper;

public class WorkScheduleMapper {

    public static WorkSchedule mapToBusiness(WorkScheduleByPageSearchRequest searchRequest) {

        return WorkSchedule.builder()
                .name(searchRequest.getName())
                .active(searchRequest.getActive())
                .company(CompanyMapper.mapToCompany(searchRequest.getCompanyId()))
                .build();

    }

    public static WorkScheduleSearchResponse mapToResponseSearch(WorkSchedule business) {

        return WorkScheduleSearchResponse.builder()
                .id(business.getId())
                .company(CompanyMapper.mapToResponse(business.getCompany()))
                .active(business.getActive())
                .departureTolerance(business.getDepartureTolerance())
                .name(business.getName())
                .openingTolerance(business.getOpeningTolerance())
                .build();

    }

    public static WorkSchedule mapToBusiness(WorkScheduleCreateRequest createRequest) {

        return WorkSchedule.builder()
                .name(createRequest.getName())
                .active(createRequest.getActive())
                .company(CompanyMapper.mapToCompany(createRequest.getCompany()))
                .departureTolerance(createRequest.getDepartureTolerance())
                .openingTolerance(createRequest.getOpeningTolerance())
                .build();

    }

    public static WorkScheduleResponse mapToIdResponse(WorkSchedule business) {

        return WorkScheduleResponse.builder()
                .id(business.getId())
                .build();

    }

    public static WorkSchedule mapToBusiness(Integer id, WorkScheduleUpdateRequest updateRequest) {

        return WorkSchedule.builder()
                .id(id)
                .name(updateRequest.getName())
                .active(updateRequest.getActive())
                .company(CompanyMapper.mapToCompany(updateRequest.getCompany()))
                .departureTolerance(updateRequest.getDepartureTolerance())
                .openingTolerance(updateRequest.getOpeningTolerance())
                .build();

    }

    public static WorkScheduleResponse mapToResponse(WorkSchedule business) {

        return WorkScheduleResponse.builder()
                .id(business.getId())
                .company(CompanyMapper.mapToResponse(business.getCompany()))
                .active(business.getActive())
                .departureTolerance(business.getDepartureTolerance())
                .name(business.getName())
                .openingTolerance(business.getOpeningTolerance())
                .build();

    }

    public static WorkScheduleResponse mapToShortResponse(WorkSchedule business) {

        return WorkScheduleResponse.builder()
                .id(business.getId())
                .company(CompanyMapper.mapToResponse(business.getCompany()))
                .name(business.getName())
                .build();

    }

    public static WorkSchedule mapToBusiness(Integer parentId) {

        return WorkSchedule.builder()
                .id(parentId)
                .build();

    }

}
