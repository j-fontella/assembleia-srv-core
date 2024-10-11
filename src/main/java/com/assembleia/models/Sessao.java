package com.assembleia.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.assembleia.utils.ValueUtils.isNotEmpty;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sessao", schema = "assembleia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Sessao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    @OneToMany(mappedBy = "sessao", cascade = ALL)
    private List<RegistroVoto> votos;

    private LocalDateTime dataHoraFinalSessao;

    public Sessao(Pauta pauta, LocalDateTime dataHoraFinalSessao) {
        this.pauta = pauta;
        this.dataHoraFinalSessao = isNotEmpty(dataHoraFinalSessao) ? dataHoraFinalSessao : LocalDateTime.now().plusMinutes(1);
    }

}
