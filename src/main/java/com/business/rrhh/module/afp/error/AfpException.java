package com.business.rrhh.module.afp.error;

import com.business.rrhh.util.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum AfpException {

    NOT_FOUND("0001", "No se encontró la AFP", HttpStatus.NOT_FOUND),
    NAME_ALREADY_EXISTS("0002", "Ya existe una AFP con ese nombre", HttpStatus.CONFLICT);

    private String code;
    private String description;
    private HttpStatus status;

    AfpException(String code, String description, HttpStatus status) {
        this.code = "AFP-".concat(code);
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
