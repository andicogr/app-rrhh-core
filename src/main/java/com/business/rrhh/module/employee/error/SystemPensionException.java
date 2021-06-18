package com.business.rrhh.module.employee.error;

import com.business.rrhh.util.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum SystemPensionException {

    NOT_FOUND("0001", "No se encontró registro de sistema de pensión para el empleado", HttpStatus.NOT_FOUND),
    ALREADY_EXISTS("0002", "Ya existe un registro de sistema de pensión para el empleado", HttpStatus.CONFLICT);

    private String code;
    private String description;
    private HttpStatus status;

    SystemPensionException(String code, String description, HttpStatus status) {
        this.code = "SYSTEM-PENSION-".concat(code);
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
