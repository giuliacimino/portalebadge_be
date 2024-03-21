package it.prova.portalebadge.dto;


import it.prova.portalebadge.model.AmbitoLavorativo;
import it.prova.portalebadge.model.Badge;
import it.prova.portalebadge.model.enumerations.Scadenza;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BadgeDTO {
    private Long id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String codiceFiscale;
    private Scadenza scadenza;
    private List<AmbitoLavorativo> ambitiLavorativi;

    public Badge buildBadgeModel() {
        return Badge.builder()
                .id(id)
                .nome(nome)
                .cognome(cognome)
                .dataNascita(dataNascita)
                .codiceFiscale(codiceFiscale)
                .ambitiLavorativi(ambitiLavorativi)
                .build();
    }

    public static BadgeDTO buildBadgeDTOFromModel(Badge badgeModel) {

        BadgeDTO result = BadgeDTO.builder().id(badgeModel.getId()).nome(badgeModel.getNome())
                .cognome(badgeModel.getCognome()).dataNascita(badgeModel.getDataNascita()).codiceFiscale(badgeModel.getCodiceFiscale())
                .ambitiLavorativi(badgeModel.getAmbitiLavorativi()).build();

        return result;
    }


    public static List<BadgeDTO> createBadgeDTOListFromModelList(List<Badge> modelListInput) {
        return modelListInput.stream().map(inputEntity -> {
            return BadgeDTO.buildBadgeDTOFromModel(inputEntity);
        }).collect(Collectors.toList());
    }



}