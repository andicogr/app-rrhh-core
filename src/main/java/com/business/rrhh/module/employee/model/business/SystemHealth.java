package com.business.rrhh.module.employee.model.business;

import com.business.rrhh.module.employee.SystemHealthType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class SystemHealth {

    private Integer id;

    private Employee employee;

    private SystemHealthType type;

    private LocalDate startDate;

}
