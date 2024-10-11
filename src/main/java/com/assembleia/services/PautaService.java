package com.assembleia.services;

import com.assembleia.dto.request.RegistrarPautaDTO;
import com.assembleia.models.Pauta;
import com.assembleia.exceptions.NegocioException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.assembleia.repositorys.PautaRepository;

import java.util.Optional;

import static com.assembleia.domain.Erro.PAUTA_JA_CADASTRADA;

@Service
public class PautaService {

    @Autowired
    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    private final PautaRepository pautaRepository;

    public ResponseEntity<?> registrar(RegistrarPautaDTO dto) {
        validarPautaRegistrada(dto);
        Pauta novaPauta = new ModelMapper().map(dto, Pauta.class);
        pautaRepository.save(novaPauta);
        return ResponseEntity.ok().build();
    }

    private void validarPautaRegistrada(RegistrarPautaDTO dto) {
        Optional<Pauta> pauta = pautaRepository.findByDescricao(dto.getDescricao());
        if(pauta.isPresent()){
            throw new NegocioException(PAUTA_JA_CADASTRADA);
        }
    }
}
