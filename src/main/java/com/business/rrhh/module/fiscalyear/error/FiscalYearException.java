package com.business.rrhh.module.fiscalyear.error;

import com.business.rrhh.util.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum FiscalYearException {

    NOT_FOUND("0001", "No se encontró el año fiscal", HttpStatus.NOT_FOUND),
    YEAR_ALREADY_EXISTS("0002", "Ya existe el año fiscal", HttpStatus.CONFLICT);

    private String code;
    private String description;
    private HttpStatus status;

    FiscalYearException(String code, String description, HttpStatus status) {
        this.code = "FISCAL-YEAR-".concat(code);
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
