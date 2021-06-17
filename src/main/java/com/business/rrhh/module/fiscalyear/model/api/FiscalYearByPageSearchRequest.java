package com.business.rrhh.module.fiscalyear.model.api;

import com.business.rrhh.util.model.api.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiscalYearByPageSearchRequest extends PageSearch {

    private Integer year;
    private String state;

}
