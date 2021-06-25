package com.business.rrhh.util.controller.mapper;

import com.business.rrhh.util.model.api.StateResponse;
import com.business.rrhh.util.model.business.State;

public class StateMapper {

    public static StateResponse mapToResponse(State state) {

        return StateResponse.of(state.getCode(), state.getDescription());

    }

    public static State mapToState(String code) {

        return State.builder().code(code).build();

    }

}
