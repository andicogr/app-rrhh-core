package com.business.rrhh.module.employee.model.business;

import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.sunat.annex.two.model.business.Table3;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Employee {

    private Integer id;
    private String firstName;
    private String secondName;
    private String paternalName;
    private String maternalName;
    private String fullName;
    private String status;
    private Table3 documentType;
    private String documentNumber;
    private String email;
    private String workPhone;
    private String mobilePhone;
    private LocalDate bornDate;
    private Company company;

}
