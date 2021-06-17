package com.business.rrhh.module.fiscalyear.model.api;

import com.business.rrhh.util.model.api.StateResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FiscalYearSearchResponse {

    private Integer id;
    private Integer year;
    private StateResponse state;

}
