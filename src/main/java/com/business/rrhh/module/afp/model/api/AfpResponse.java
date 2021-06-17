package com.business.rrhh.module.afp.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AfpResponse {

    private Integer id;
    private String name;
    private Boolean active;

}
