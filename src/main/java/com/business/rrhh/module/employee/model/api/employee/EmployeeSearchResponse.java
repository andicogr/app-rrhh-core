package com.business.rrhh.module.employee.model.api.employee;

import com.business.rrhh.util.DocType;
import com.business.rrhh.util.model.api.CompanyResponse;
import com.business.rrhh.util.model.api.StateResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeSearchResponse {

    private Integer id;
    private String firstName;
    private String secondName;
    private String paternalName;
    private String maternalName;
    private String fullName;
    private StateResponse state;
    private DocType documentType;
    private String documentNumber;
    private CompanyResponse company;

}
