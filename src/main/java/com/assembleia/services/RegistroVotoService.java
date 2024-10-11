package com.assembleia.services;

import com.assembleia.exceptions.NegocioException;
import com.assembleia.models.RegistroVoto;
import com.assembleia.models.Sessao;
import com.assembleia.repositorys.RegistroVotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.assembleia.domain.Erro.ASSOCIADO_JA_VOTOU;

@Service
public class RegistroVotoService {

    private final RegistroVotoRepository registroVotoRepository;

    @Autowired
    public RegistroVotoService(RegistroVotoRepository registroVotoRepository) {
        this.registroVotoRepository = registroVotoRepository;
    }

    public void validaVotoAssociado(Sessao sessao, Long idAssociado) {
        Optional<RegistroVoto> registroVoto = registroVotoRepository.findBySessaoAndIdAssociado(sessao, idAssociado);
        if(registroVoto.isPresent()){
            throw new NegocioException(ASSOCIADO_JA_VOTOU);
        }
    }

    public void salvar(RegistroVoto registroVoto) {
        registroVotoRepository.save(registroVoto);
    }

}
