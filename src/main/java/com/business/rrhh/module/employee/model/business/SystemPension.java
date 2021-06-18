package com.business.rrhh.module.employee.model.business;

import com.business.rrhh.module.afp.AfpType;
import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.employee.SystemPensionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
public class SystemPension {

    private Integer id;

    private Employee employee;

    private SystemPensionType type;

    private LocalDate startDate;

    private Afp afp;

    private AfpType afpType;

    private String cusppCode;

}
