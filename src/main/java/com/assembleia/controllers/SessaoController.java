package com.assembleia.controllers;

import com.assembleia.dto.request.RegistrarSessaoDTO;
import com.assembleia.dto.request.RegistroVotoDTO;
import com.assembleia.dto.response.ResultadoVotacaoDTO;
import com.assembleia.services.SessaoService;
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

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody @Valid RegistrarSessaoDTO dto) {
        return sessaoService.registrar(dto);
    }

    @PostMapping("/votar")
    public ResponseEntity<?> votar(@RequestBody @Valid RegistroVotoDTO dto) {
        return sessaoService.votar(dto);
    }

    @GetMapping(value = "/contabilizar/{idSessao}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultadoVotacaoDTO> contabilizar(@PathVariable Long idSessao) {
        return sessaoService.contabilizar(idSessao);
    }


}
