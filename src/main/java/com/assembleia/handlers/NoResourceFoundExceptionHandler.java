package com.assembleia.handlers;

import com.assembleia.domain.RetornoErro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class NoResourceFoundExceptionHandler extends GenericExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<RetornoErro> handleException(NoResourceFoundException e) {
        return super.handleException();
    }
}
