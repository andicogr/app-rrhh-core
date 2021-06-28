package com.business.rrhh.module.user.error;

import com.business.rrhh.util.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum UserException {

    USER_NOT_FOUND("0001", "No se encontró el usuario", HttpStatus.NOT_FOUND),
    INVALID_USER_CREATION("0002","Datos invalidos", HttpStatus.NOT_FOUND);

    private String code;
    private String description;
    private HttpStatus status;

    UserException(String code, String description, HttpStatus status) {
        this.code = "USER-".concat(code);
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

    public ApiException build(String... details){
        return ApiException.builder()
                .code(this.code)
                .description(this.description)
                .status(this.status)
                .details(Arrays.asList(details))
                .build();
    }

}
