package com.assembleia.handlers;

import com.assembleia.domain.RetornoErro;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class RunTimeExceptionHandler {

    public ResponseEntity<RetornoErro> handleException(RuntimeException e) {
        RetornoErro retornoErro = new RetornoErro();
        retornoErro.getErros().add(e.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(retornoErro);
    }


}
