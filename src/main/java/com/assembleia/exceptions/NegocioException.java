package com.assembleia.exceptions;

import com.assembleia.domain.Erro;

public class NegocioException extends RuntimeException {

    public NegocioException(Erro erro) {
        super(erro.toString());
    }
}
