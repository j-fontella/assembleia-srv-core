package com.assembleia.repositorys;

import com.assembleia.models.RegistroVoto;
import com.assembleia.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistroVotoRepository extends JpaRepository<RegistroVoto, Long> {

    Optional<RegistroVoto> findBySessaoAndIdAssociado(Sessao sessao, Long idAssociado);
}
