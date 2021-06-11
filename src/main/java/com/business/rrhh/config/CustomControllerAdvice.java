package com.business.rrhh.config;

import com.business.rrhh.util.ApiException;
import com.business.rrhh.util.ExceptionDetail;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;

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
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDetail> handleDataIntegrityViolationException(Exception ex, WebRequest webRequest) {

        log.error("Error:", ex);

        ExceptionDetail exceptionDetail = new ExceptionDetail();
        exceptionDetail.setCode("ERROR-9999");
        exceptionDetail.setDescription("Ocurrió un error en el servicio");

        if (ex.getCause() instanceof DataException) {
            DataException dataException = (DataException) ex.getCause();

            if (dataException.getSQLException().getSQLState().equals("22001")) {
                exceptionDetail.setDetails(Arrays.asList("Uno de los campos es demasiado largo"));
            }

        }

        if (ex.getCause() instanceof ConstraintViolationException) {
            ConstraintViolationException dataException = (ConstraintViolationException) ex.getCause();

            if (dataException.getSQLException().getSQLState().equals("23505")) {
                exceptionDetail.setDetails(Arrays.asList("Uno de los campos debe ser único"));
            }
        }

        return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
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
