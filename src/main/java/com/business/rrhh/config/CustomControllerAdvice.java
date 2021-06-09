package com.business.rrhh.config;

import com.business.rrhh.util.ApiException;
import com.business.rrhh.util.ExceptionDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class CustomControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionDetail> handleApiException(ApiException ex, WebRequest webRequest) {

        log.error(ex.toString(), ex);

        ExceptionDetail exceptionDetail = new ExceptionDetail();
        exceptionDetail.setCode(ex.getCode());
        exceptionDetail.setDescription(ex.getDescription());
        exceptionDetail.setDetails(ex.getDetails());

        return new ResponseEntity<>(exceptionDetail, ex.getStatus());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetail> handleAllException(Exception ex, WebRequest webRequest) {

        log.error("Error:", ex);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof BindException) {
            status = HttpStatus.BAD_REQUEST;
        }

        ExceptionDetail exceptionDetail = new ExceptionDetail();
        exceptionDetail.setCode("ERROR-9999");
        exceptionDetail.setDescription("Ocurrio un error en el servicio");

        return new ResponseEntity<>(exceptionDetail, status);
    }

}
