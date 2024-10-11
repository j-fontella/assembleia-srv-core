package com.assembleia.repositorys;

import com.assembleia.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    @Query(value = "SELECT EXISTS (SELECT 1 FROM assembleia.sessao s " +
            "WHERE s.pauta_id = :pautaId AND s.datahorafinalsessao > CURRENT_TIMESTAMP)",
            nativeQuery = true)
    boolean findSessaoAtiva(@Param("pautaId") Long pautaId);
}
