package com.assembleia.controllers;

import com.assembleia.dto.request.RegistrarSessaoDTO;
import com.assembleia.dto.request.RegistroVotoDTO;
import com.assembleia.dto.response.ResultadoVotacaoDTO;
import com.assembleia.services.SessaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/sessao")
public class SessaoController {

    private final SessaoService sessaoService;

    @Autowired
    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @Operation(summary = "Registrar uma nova sessão de votação", description = "Este endpoint registra uma nova sessão de votação com base nos dados fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sessão de votação registrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar sessão")
    })
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@Parameter(description = "Dados da sessão a serem registrados", required = true)
                                       @RequestBody @Valid RegistrarSessaoDTO dto) {
        return sessaoService.registrar(dto);
    }

    @Operation(summary = "Registrar um voto", description = "Este endpoint permite que um associado registre seu voto em uma sessão de votação.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Voto registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao registrar voto")
    })
    @PostMapping("/votar")
    public ResponseEntity<?> votar(@Parameter(description = "Dados do voto a serem registrados", required = true)
                                   @RequestBody @Valid RegistroVotoDTO dto) {
        return sessaoService.votar(dto);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Votos contabilizados com sucesso",
                         content = @Content(mediaType = "application/json",
                         schema = @Schema(implementation = ResultadoVotacaoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Sessão não encontrada")
    })
    @GetMapping(value = "/contabilizar/{idSessao}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultadoVotacaoDTO> contabilizar(@PathVariable Long idSessao) {
        return sessaoService.contabilizar(idSessao);
    }


}
