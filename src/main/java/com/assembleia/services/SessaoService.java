package com.assembleia.services;

import com.assembleia.domain.Voto;
import com.assembleia.dto.request.RegistrarSessaoDTO;
import com.assembleia.dto.request.RegistroVotoDTO;
import com.assembleia.exceptions.NegocioException;
import com.assembleia.models.Pauta;
import com.assembleia.models.RegistroVoto;
import com.assembleia.models.Sessao;
import com.assembleia.repositorys.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.assembleia.domain.Erro.*;
import static java.time.LocalDateTime.now;

@Service
public class SessaoService {

    private final SessaoRepository sessaoRepository;
    private final PautaService pautaService;
    private final RegistroVotoService registroVotoService;

    @Autowired
    public SessaoService(SessaoRepository sessaoRepository, PautaService pautaService, RegistroVotoService registroVotoService) {
        this.sessaoRepository = sessaoRepository;
        this.pautaService = pautaService;
        this.registroVotoService = registroVotoService;
    }

    public ResponseEntity<?> registrar(RegistrarSessaoDTO dto) {
        Pauta pauta = pautaService.buscarPauta(dto.getIdPauta());
        validarSessaoComPautaRegistrada(pauta);
        Sessao novaSessao = new Sessao(pauta, dto.getDataHoraFinalSessao());
        sessaoRepository.save(novaSessao);
        return ResponseEntity.ok().build();
    }

    private void validarSessaoComPautaRegistrada(Pauta pauta) {
        if(sessaoRepository.possuiSessaoAtiva(pauta.getId())){
            throw new NegocioException(SESSAO_JA_CADASTRADA);
        }
    }

    public ResponseEntity<?> votar(RegistroVotoDTO dto) {
        Sessao sessao = buscarSessao(dto.getIdSessao());
        registroVotoService.validaVotoAssociado(sessao, dto.getIdAssociado());
        registrarVoto(sessao, dto.getIdAssociado(), dto.getVoto());
        return ResponseEntity.ok().build();
    }

    private void registrarVoto(Sessao sessao, Long idAssociado, Voto voto) {
        RegistroVoto registroVoto = new RegistroVoto(voto, sessao, idAssociado);
        registroVotoService.salvar(registroVoto);
    }

    private Sessao buscarSessao(Long id){
        Optional<Sessao> buscaSessao = sessaoRepository.findById(id);
        if(buscaSessao.isEmpty()){
            throw new NegocioException(SESSAO_NAO_CADASTRADA);
        }

        Sessao sessao = buscaSessao.get();

        if(sessao.getDataHoraFinalSessao().isBefore(now())){
            throw new NegocioException(SESSAO_ENCERRADA);
        }

        return sessao;
    }


}
