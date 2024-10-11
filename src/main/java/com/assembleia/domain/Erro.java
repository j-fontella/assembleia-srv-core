package com.assembleia.domain;

import lombok.Getter;

@Getter
public enum Erro {


    PAUTA_JA_CADASTRADA("Esta pauta já está cadastrado no sistema");

    private final String descricao;

    Erro(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
