package com.assembleia.handlers;

import com.assembleia.domain.RetornoErro;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.assembleia.domain.Erro.ERRO_GENERICO;

@ControllerAdvice
public class HttpMessageNotReadableExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RetornoErro> handleException(HttpMessageNotReadableException e) {
        RetornoErro erros = new RetornoErro();
        erros.getErros().add(ERRO_GENERICO.toString());
        return ResponseEntity.badRequest().body(erros);
    }


}
