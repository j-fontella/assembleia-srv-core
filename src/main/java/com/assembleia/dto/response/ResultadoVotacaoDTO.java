package com.assembleia.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ResultadoVotacaoDTO {

    @Schema(description = "Descrição da pauta da sessão", example = "Reforma do estatuto")
    private String descricaoPauta;

    @Schema(description = "Quantidade de votos SIM", example = "42")
    private long quantidadeSim;

    @Schema(description = "Quantidade de votos NÃO", example = "18")
    private long quantidadeNao;

    @Schema(description = "Resultado da votação", example = "Aprovado")
    private String resultado;
}
