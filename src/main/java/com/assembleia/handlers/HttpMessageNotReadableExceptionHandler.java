package com.assembleia.handlers;

import com.assembleia.domain.RetornoErro;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpMessageNotReadableExceptionHandler extends GenericExceptionHandler{

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RetornoErro> handleException(HttpMessageNotReadableException e) {
        return super.handleException();
    }


}
