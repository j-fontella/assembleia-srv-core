package com.assembleia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrarPautaDTO {

    @NotBlank(message = "O nome deve ser preennchido")
    @Schema(description = "Descrição da pauta", example = "Pauta de votação sobre o orçamento")
    private String descricao;

}
