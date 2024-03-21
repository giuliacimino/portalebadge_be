package it.prova.portalebadge.model.enumerations;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Scadenza {
    BADGE_TEMPORANEO("badge temporaneo"),
    BADGE_PERMANENTE("badge permanente");

    private final String descrizione;




}
