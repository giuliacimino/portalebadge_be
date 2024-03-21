package it.prova.portalebadge.model;


import it.prova.portalebadge.model.enumerations.Scadenza;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="badge")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "dataNascita")
    private LocalDate dataNascita;

    @Column(name = "codiceFiscale")
    private String codiceFiscale;


    @Column(name = "scadenza")
    @Enumerated(EnumType.STRING)
    private Scadenza scadenza;

    @ManyToMany
    @JoinTable(
            name = "badge_ambito_lavorativo",
            joinColumns = @JoinColumn(name = "badge_id"),
            inverseJoinColumns = @JoinColumn(name = "ambito_lavorativo_id")
    )
    private List<AmbitoLavorativo> ambitiLavorativi;









}
