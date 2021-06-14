package com.business.rrhh.module.salary.state;

import com.business.rrhh.util.model.business.State;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum SalaryStates {

    DRAFT(1, "draft", "Borrador", true, false),
    ACTIVE(2, "active", "Activo", false, false),
    FINISH(3, "finish", "Terminado", false, false);

    private final Integer order;

    @Getter
    private final String code;

    @Getter
    private final String description;
    private final boolean first;
    private final boolean last;


    SalaryStates(Integer order, String code, String description, boolean first, boolean last) {
        this.order = order;
        this.code = code;
        this.description = description;
        this.first = first;
        this.last = last;
    }

    public static final SalaryStates getByCode(String code) {

        if (StringUtils.isEmpty(code)) {
            return SalaryStates.DRAFT;
        }

        return Stream.of(SalaryStates.values())
                .filter(states -> states.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(SalaryStates.DRAFT);

    }

    public State buildState(){
        return State.builder().code(this.code).description(this.description).build();
    }

}
