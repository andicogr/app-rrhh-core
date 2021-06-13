package com.business.rrhh.module.employee.model.api;

import com.business.rrhh.module.sunat.annex.two.model.api.Table3Response;
import com.business.rrhh.util.model.api.CompanyResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

    private Integer id;
    private String firstName;
    private String secondName;
    private String paternalName;
    private String maternalName;
    private String fullName;
    private String status;
    private Table3Response documentType;
    private String documentNumber;
    private String email;
    private String workPhone;
    private String mobilePhone;
    private LocalDate bornDate;
    private CompanyResponse company;
}
