package com.business.rrhh.util.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class StateResponse {

    private String code;
    private String description;

}
