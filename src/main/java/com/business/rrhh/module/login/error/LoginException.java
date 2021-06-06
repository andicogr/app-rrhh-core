package com.business.rrhh.module.login.error;

import com.business.rrhh.util.ApiException;
import org.springframework.http.HttpStatus;

public enum LoginException {

    USER_NOT_FOUND("0001", "No se encontró el usuario", HttpStatus.NOT_FOUND);

    private String code;
    private String description;
    private HttpStatus status;

    LoginException(String code, String description, HttpStatus status) {
        this.code = "LOGIN-".concat(code);
        this.description = description;
        this.status = status;

    }

    public ApiException build(){

        return ApiException.builder()
                .code(this.code)
                .description(this.description)
                .status(this.status)
                .build();

    }

}
