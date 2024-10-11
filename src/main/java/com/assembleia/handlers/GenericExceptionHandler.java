package com.assembleia.handlers;

import com.assembleia.domain.RetornoErro;
import org.springframework.http.ResponseEntity;

import static com.assembleia.domain.Erro.ERRO_GENERICO;

public class GenericExceptionHandler {

    public ResponseEntity<RetornoErro> handleException() {
        RetornoErro retornoErro = new RetornoErro();
        retornoErro.getErros().add(ERRO_GENERICO.toString());
        return ResponseEntity.badRequest().body(retornoErro);
    }

}
