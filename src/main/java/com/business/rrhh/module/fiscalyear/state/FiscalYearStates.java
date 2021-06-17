package com.business.rrhh.module.fiscalyear.state;

import com.business.rrhh.util.model.business.State;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum FiscalYearStates {

    DRAFT(1, "draft", "Borrador", true, false),
    OPEN(2, "open", "Abierto", false, false),
    CLOSE(3, "close", "Cerrado", false, false);

    private final Integer order;

    @Getter
    private final String code;

    @Getter
    private final String description;
    private final boolean first;
    private final boolean last;


    FiscalYearStates(Integer order, String code, String description, boolean first, boolean last) {
        this.order = order;
        this.code = code;
        this.description = description;
        this.first = first;
        this.last = last;
    }

    public static final FiscalYearStates getByCode(String code) {

        if (StringUtils.isEmpty(code)) {
            return FiscalYearStates.DRAFT;
        }

        return Stream.of(FiscalYearStates.values())
                .filter(states -> states.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(FiscalYearStates.DRAFT);

    }

    public State buildState(){
        return State.builder().code(this.code).description(this.description).build();
    }

}
