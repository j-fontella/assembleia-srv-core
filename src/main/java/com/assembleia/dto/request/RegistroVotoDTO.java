package com.assembleia.dto.request;

import com.assembleia.domain.Voto;
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
    private Long idAssociado;

    @NotNull(message = "É obrigatório informar a sessão")
    private Long idSessao;

    @NotNull(message = "O voto é obrigatório")
    private Voto voto;

}
