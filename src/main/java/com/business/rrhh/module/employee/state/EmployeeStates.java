package com.business.rrhh.module.employee.state;

import com.business.rrhh.util.model.business.State;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum EmployeeStates {

    INACTIVE(1, "inactive", "Inactivo", true, false),
    ACTIVE(2, "active", "Activo", false, false),
    FINISH(3, "finish", "Liquidado", false, false);

    private final Integer order;

    @Getter
    private final String code;

    @Getter
    private final String description;
    private final boolean first;
    private final boolean last;


    EmployeeStates(Integer order, String code, String description, boolean first, boolean last) {
        this.order = order;
        this.code = code;
        this.description = description;
        this.first = first;
        this.last = last;
    }

    public static final EmployeeStates getByCode(String code) {

        if (StringUtils.isEmpty(code)) {
            return EmployeeStates.INACTIVE;
        }

        return Stream.of(EmployeeStates.values())
                .filter(states -> states.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(EmployeeStates.INACTIVE);

    }

    public State buildState(){
        return State.builder().code(this.code).description(this.description).build();
    }

}
