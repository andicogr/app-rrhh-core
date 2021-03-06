package com.business.rrhh.module.employee.model.api.employee;

import com.business.rrhh.util.DocType;
import com.business.rrhh.util.model.api.CompanyRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class EmployeeCreateRequest {

    @NotBlank
    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String secondName;

    @NotBlank
    @Size(max = 100)
    private String paternalName;

    @Size(max = 100)
    private String maternalName;

    @Valid
    @NotNull
    private DocType documentType;

    @NotBlank
    @Size(max = 15)
    private String documentNumber;

    @Size(max = 100)
    private String email;

    @Size(max = 15)
    private String workPhone;

    @Size(max = 15)
    private String mobilePhone;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate bornDate;

    @Valid
    @NotNull
    private CompanyRequest company;

}
