package com.assembleia.dto.response;


import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ResultadoVotacaoDTO {
    private String descricaoPauta;
    private long quantidadeSim;
    private long quantidadeNao;
    private String resultado;
}
