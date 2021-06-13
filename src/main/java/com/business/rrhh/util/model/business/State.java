package com.business.rrhh.util.model.business;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class State {

    private Integer order;
    private String code;
    private String description;
    private boolean first;
    private boolean last;

}
