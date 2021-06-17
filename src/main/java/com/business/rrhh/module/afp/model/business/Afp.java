package com.business.rrhh.module.afp.model.business;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Afp {

    private Integer id;
    private String name;
    private Boolean active;

}
