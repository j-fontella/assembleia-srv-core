package com.assembleia.models;


import com.assembleia.domain.Voto;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "registrovoto", schema = "assembleia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RegistroVoto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(STRING)
    private Voto voto;

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;

    private Integer idAssociado;

}
