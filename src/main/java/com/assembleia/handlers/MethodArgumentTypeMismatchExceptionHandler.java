package com.assembleia.handlers;

import com.assembleia.domain.RetornoErro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class MethodArgumentTypeMismatchExceptionHandler extends GenericExceptionHandler{

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<RetornoErro> handleException(MethodArgumentTypeMismatchException e) {
        return super.handleException();
    }
}
