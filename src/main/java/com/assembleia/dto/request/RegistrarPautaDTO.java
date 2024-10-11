package com.assembleia.dto.request;

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
    private String descricao;

}
