package com.business.rrhh.module.workschedule.model.business;

import com.business.rrhh.module.company.model.business.Company;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkSchedule {

    private Integer id;
    private String name;
    private Integer openingTolerance;
    private Integer departureTolerance;
    private Boolean active;
    private List<WorkScheduleDetail> details;
    private Company company;


}
