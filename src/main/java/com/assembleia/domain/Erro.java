package com.assembleia.domain;

import lombok.Getter;

@Getter
public enum Erro {


    PAUTA_JA_CADASTRADA("Esta pauta já está cadastrada no sistema"),
    PAUTA_NAO_CADASTRADA("Esta pauta não está cadastrada no sistema"),
    SESSAO_JA_CADASTRADA("Esta pauta já tem uma votação ativa");

    private final String descricao;

    Erro(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
