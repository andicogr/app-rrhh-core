package com.business.rrhh.util.model.api;

import com.business.rrhh.util.model.business.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateBarResponse {

    private StateResponse status;
    private boolean current;
    private boolean next;
    private boolean last;

    public StateBarResponse(State status) {
        super();
        this.status = StateResponse.of(status.getCode(), status.getDescription());

    }

}
