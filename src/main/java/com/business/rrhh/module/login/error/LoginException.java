package com.business.rrhh.module.login.error;

import com.business.rrhh.util.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public enum LoginException {

    BAD_CREDENTIALS("0001", "Usuario y/o contraseña incorrectos", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("0002", "No se encontró el usuario", HttpStatus.NOT_FOUND),
    INVALID_USER_CREATION("0003","Datos invalidos", HttpStatus.NOT_FOUND);

    private String code;
    private String description;
    private HttpStatus status;

    LoginException(String code, String description, HttpStatus status) {
        this.code = "LOGIN-".concat(code);
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
                .details(Arrays.asList(details))
                .build();
    }

}
