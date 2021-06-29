package com.business.rrhh.module.employee.model.api.employee;

import com.business.rrhh.util.DocType;
import com.business.rrhh.util.model.api.CompanyResponse;
import com.business.rrhh.util.model.api.StateResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
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
    private StateResponse state;
    private DocType documentType;
    private String documentNumber;
    private String email;
    private String workPhone;
    private String mobilePhone;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate bornDate;
    private CompanyResponse company;
}
