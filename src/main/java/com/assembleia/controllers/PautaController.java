package com.assembleia.controllers;

import com.assembleia.dto.request.RegistrarPautaDTO;
import com.assembleia.services.PautaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/pauta")
public class PautaController {

    private final PautaService pautaService;

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @Operation(summary = "Registrar uma nova pauta", description = "Este endpoint registra uma nova pauta para ser votada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pauta registrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao registrar a pauta")
    })
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@Parameter(description = "Dados da pauta a ser registrada", required = true)
                                       @RequestBody @Valid RegistrarPautaDTO dto) {
        return pautaService.registrar(dto);
    }


}
