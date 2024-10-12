package com.assembleia.dto.request;

import com.assembleia.domain.Voto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroVotoDTO {

    @NotNull(message = "É obrigatório informar o id do associado")
    @Schema(description = "ID do associado que está votando", example = "123")
    private Long idAssociado;

    @NotNull(message = "É obrigatório informar a sessão")
    @Schema(description = "ID da sessão de votação", example = "10")
    private Long idSessao;

    @NotNull(message = "O voto é obrigatório")
    @Schema(description = "Voto do associado, que pode ser SIM ou NÃO", example = "SIM")
    private Voto voto;

}
