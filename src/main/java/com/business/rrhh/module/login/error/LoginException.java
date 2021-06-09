package com.business.rrhh.module.login.error;

import com.business.rrhh.util.ApiException;
import org.springframework.http.HttpStatus;

public enum LoginException {

    BAD_CREDENTIALS("0001", "Usuario y/o contraseña incorrectos", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("0002", "No se encontró el usuario", HttpStatus.NOT_FOUND);


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
