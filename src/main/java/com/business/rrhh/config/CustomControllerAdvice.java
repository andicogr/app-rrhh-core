package com.business.rrhh.config;

import com.business.rrhh.util.ApiException;
import com.business.rrhh.util.ExceptionDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionDetail> handleApiException(ApiException ex, WebRequest webRequest) {

        log.error(ex.toString());

        ExceptionDetail exceptionDetail = new ExceptionDetail();
        exceptionDetail.setCode(ex.getCode());
        exceptionDetail.setDescription(ex.getDescription());

        return new ResponseEntity<>(exceptionDetail, ex.getStatus());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetail> handleAllException(Exception ex, WebRequest webRequest) {

        log.error(ex.toString());

        ExceptionDetail exceptionDetail = new ExceptionDetail();
        exceptionDetail.setCode("ERROR-9999");
        exceptionDetail.setDescription("Ocurrio un error en el servicio");

        return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
