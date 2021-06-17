package com.business.rrhh.module.salary.error;

import com.business.rrhh.module.salary.state.SalaryStates;
import com.business.rrhh.util.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum SalaryException {

    NOT_FOUND("0001", "No se encontró el sueldo del empleado", HttpStatus.NOT_FOUND),
    WRONG_DATES("0002", "La fecha de inicio no puede ser mayor o igual a la fecha de fin", HttpStatus.CONFLICT),
    CANT_DELETE_NOT_DRAFT_STATE("0003", "No se puede elminar un sueldo en estado diferente de ".concat(SalaryStates.DRAFT.getDescription()), HttpStatus.CONFLICT),
    ACTIVE_SALARY_BY_EMPLOYEE("0004", "Ya existe un sueldo activo para el empleado", HttpStatus.CONFLICT),
    INVALID_DATE("0005", "La fecha de inicio del sueldo debe ser mayor a %s", HttpStatus.CONFLICT),
    END_DATE_REQUIRED("0006", "Ingrese una fecha de fin para el sueldo", HttpStatus.CONFLICT);

    private String code;
    private String description;
    private HttpStatus status;

    SalaryException(String code, String description, HttpStatus status) {
        this.code = "SALARY-".concat(code);
        this.description = description;
        this.status = status;

    }

    public ApiException build() {

        return this.build(null);

    }

    public ApiException build(String... details) {
        return ApiException.builder()
                .code(this.code)
                .description(this.description)
                .status(this.status)
                .details(details != null ? Arrays.asList(details) : null)
                .build();
    }

    public ApiException.ApiExceptionBuilder descriptionParams(String... params) {
        return ApiException.builder()
                .code(this.code)
                .description(String.format(this.description, params))
                .status(this.status)
                .details(null);
    }

}
