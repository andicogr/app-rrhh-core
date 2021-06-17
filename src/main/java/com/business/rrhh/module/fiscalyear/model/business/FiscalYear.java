package com.business.rrhh.module.fiscalyear.model.business;

import com.business.rrhh.util.model.business.State;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FiscalYear {

    private Integer id;
    private Integer year;
    private State state;

}
