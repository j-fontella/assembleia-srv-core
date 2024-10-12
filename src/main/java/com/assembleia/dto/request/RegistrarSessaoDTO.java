package com.assembleia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrarSessaoDTO {

    @NotNull(message = "É obrigatório informar a pauta")
    @Schema(description = "ID da pauta a ser associada à sessão", example = "1")
    private Long idPauta;

    @Future(message = "A data deve ser posterior a de agora")
    @Schema(description = "Data e hora final da sessão de votação, deve ser posterior a data atual", example = "2024-12-31T23:59:59")
    private LocalDateTime dataHoraFinalSessao;

}
