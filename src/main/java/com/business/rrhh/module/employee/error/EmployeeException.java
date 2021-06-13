package com.business.rrhh.module.employee.error;

import com.business.rrhh.util.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum EmployeeException {

    NOT_FOUND("0001", "No se encontró el empleado", HttpStatus.NOT_FOUND),
    DOC_NUMBER_AND_DOC_TYPE_ALREADY_USED("0002", "Ya existe un empleado con el mismo número y tipo de documento", HttpStatus.CONFLICT);

    private String code;
    private String description;
    private HttpStatus status;

    EmployeeException(String code, String description, HttpStatus status) {
        this.code = "EMPLOYEE-".concat(code);
        this.description = description;
        this.status = status;

    }

    public ApiException build(){

        return this.build(null);

    }

    public ApiException build(String... details){
        return ApiException.builder()
                .code(this.code)
                .description(this.description)
                .status(this.status)
                .details(details != null ? Arrays.asList(details) : null)
                .build();
    }

}
