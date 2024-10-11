package com.assembleia.repositorys;

import com.assembleia.models.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PautaRepository extends JpaRepository<Pauta, Long> {

    Optional<Pauta> findByDescricao(String descricao);
}
