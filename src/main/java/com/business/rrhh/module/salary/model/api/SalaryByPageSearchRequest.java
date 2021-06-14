package com.business.rrhh.module.salary.model.api;

import com.business.rrhh.util.model.api.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryByPageSearchRequest extends PageSearch {

    private Integer companyId;
    private Integer employeeId;
    private String state;

}
