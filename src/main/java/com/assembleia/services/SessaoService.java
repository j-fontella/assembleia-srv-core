package com.assembleia.services;

import com.assembleia.dto.request.RegistrarSessaoDTO;
import com.assembleia.exceptions.NegocioException;
import com.assembleia.models.Pauta;
import com.assembleia.models.Sessao;
import com.assembleia.repositorys.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.assembleia.domain.Erro.SESSAO_JA_CADASTRADA;

@Service
public class SessaoService {

    private final SessaoRepository sessaoRepository;
    private final PautaService pautaService;

    @Autowired
    public SessaoService(SessaoRepository sessaoRepository, PautaService pautaService) {
        this.sessaoRepository = sessaoRepository;
        this.pautaService = pautaService;
    }

    public ResponseEntity<?> registrar(RegistrarSessaoDTO dto) {
        Pauta pauta = pautaService.buscarPauta(dto.getIdPauta());
        validarSessaoComPautaRegistrada(pauta);
        Sessao novaSessao = new Sessao(pauta, dto.getDataHoraFinalSessao());
        sessaoRepository.save(novaSessao);
        return ResponseEntity.ok().build();
    }

    private void validarSessaoComPautaRegistrada(Pauta pauta) {
        if(sessaoRepository.findSessaoAtiva(pauta.getId())){
            throw new NegocioException(SESSAO_JA_CADASTRADA);
        }
    }

}
