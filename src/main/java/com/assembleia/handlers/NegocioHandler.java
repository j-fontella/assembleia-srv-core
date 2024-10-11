package com.assembleia.handlers;

import com.assembleia.domain.RetornoErro;
import com.assembleia.exceptions.NegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NegocioHandler extends RunTimeExceptionHandler{

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<RetornoErro> handleException(NegocioException e) {
        return super.handleException(e);
    }


}
