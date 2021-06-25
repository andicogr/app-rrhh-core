package com.business.rrhh.module.login.state;

import com.business.rrhh.util.model.business.State;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum UserStates {

    INACTIVE(1, "inactive", "Inactivo"),
    ACTIVE(2, "active", "Activo");

    private final Integer order;

    @Getter
    private final String code;

    @Getter
    private final String description;


    UserStates(Integer order, String code, String description) {
        this.order = order;
        this.code = code;
        this.description = description;
    }

    public static final UserStates getByCode(String code) {

        if (StringUtils.isEmpty(code)) {
            return UserStates.INACTIVE;
        }

        return Stream.of(UserStates.values())
                .filter(states -> states.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(UserStates.INACTIVE);

    }

    public State buildState(){
        return State.builder().code(this.code).description(this.description).build();
    }

}
