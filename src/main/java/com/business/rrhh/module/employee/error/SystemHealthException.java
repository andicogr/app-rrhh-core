package com.business.rrhh.module.employee.error;

import com.business.rrhh.util.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum SystemHealthException {

    NOT_FOUND("0001", "No se encontró registro de sistema de salud para el empleado", HttpStatus.NOT_FOUND),
    ALREADY_EXISTS("0002", "Ya existe un registro de sistema de salud para el empleado", HttpStatus.CONFLICT);

    private String code;
    private String description;
    private HttpStatus status;

    SystemHealthException(String code, String description, HttpStatus status) {
        this.code = "SYSTEM-HEALTH-".concat(code);
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
