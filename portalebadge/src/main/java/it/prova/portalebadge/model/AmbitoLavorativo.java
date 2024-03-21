package it.prova.portalebadge.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ambito_lavorativo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmbitoLavorativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "ambitiLavorativi")
    private List<Badge> badges;

}
