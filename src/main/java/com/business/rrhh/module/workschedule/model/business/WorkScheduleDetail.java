package com.business.rrhh.module.workschedule.model.business;

import com.business.rrhh.util.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Builder
public class WorkScheduleDetail {

    private Integer id;
    private WorkSchedule workSchedule;
    private DayOfWeek dayOfWeek;
    private LocalTime openingTime;
    private LocalTime departureTime;
    private LocalTime workTime;

    public void calculateWorkTime() {

        if (this.openingTime != null && this.departureTime != null) {
            this.workTime = DateUtil.getTimeBetween(this.openingTime, this.departureTime);
        }

    }

    public int getOrder(){

        return this.dayOfWeek.ordinal();
        
    }

}
