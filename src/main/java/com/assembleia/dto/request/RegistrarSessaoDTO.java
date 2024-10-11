package com.assembleia.dto.request;

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
    private Long idPauta;

    @Future(message = "A data deve ser posterior a de agora")
    private LocalDateTime dataHoraFinalSessao;

}
