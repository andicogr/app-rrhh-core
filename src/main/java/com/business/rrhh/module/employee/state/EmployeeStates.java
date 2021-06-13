package com.business.rrhh.module.employee.state;

import com.business.rrhh.util.model.business.State;
import com.business.rrhh.util.state.BaseState;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStates extends BaseState {

    public static final EmployeeStates instance = new EmployeeStates();

    public EmployeeStates() {

        List<State> statusList = new ArrayList<>();
        statusList.add(State.builder().order(1).code("inactive").description("Inactivo").first(true).build());
        statusList.add(State.builder().order(2).code("active").description("Activo").build());
        statusList.add(State.builder().order(3).code("finish").description("Liquidado").last(true).build());

        this.setStatusList(statusList);

    }

}
