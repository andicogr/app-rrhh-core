package com.business.rrhh.module.company.state;

import com.business.rrhh.util.model.business.State;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum CompanyStates {

    INACTIVE(1, "inactive", "Inactivo"),
    ACTIVE(2, "active", "Activo");

    private final Integer order;

    @Getter
    private final String code;

    @Getter
    private final String description;


    CompanyStates(Integer order, String code, String description) {
        this.order = order;
        this.code = code;
        this.description = description;
    }

    public static final CompanyStates getByCode(String code) {

        if (StringUtils.isEmpty(code)) {
            return CompanyStates.INACTIVE;
        }

        return Stream.of(CompanyStates.values())
                .filter(states -> states.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(CompanyStates.INACTIVE);

    }

    public State buildState(){
        return State.builder().code(this.code).description(this.description).build();
    }

}
