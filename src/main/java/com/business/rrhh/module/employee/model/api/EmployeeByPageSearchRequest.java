package com.business.rrhh.module.employee.model.api;

import com.business.rrhh.util.model.api.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeByPageSearchRequest extends PageSearch {

    private String documentType;
    private String documentNumber;
    private String firstName;
    private String secondName;
    private String paternalName;
    private String maternalName;
    private String state;
    private Integer companyId;

}
