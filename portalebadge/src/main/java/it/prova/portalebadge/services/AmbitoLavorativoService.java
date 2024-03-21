package it.prova.portalebadge.services;

import it.prova.portalebadge.model.AmbitoLavorativo;
import it.prova.portalebadge.model.Badge;

import java.util.List;

public interface AmbitoLavorativoService {
    public List<AmbitoLavorativo> listAllAmbitiLavorativi();
    public AmbitoLavorativo getAmbitoLavorativo(Long id);

    public AmbitoLavorativo updateAmbitoLavorativo(AmbitoLavorativo ambitoLavorativoInstance);

    public AmbitoLavorativo insertAmbitoLavorativo(AmbitoLavorativo ambitoLavorativoInstance);

    public void deleteAmbitoLavorativo(Long id);
}
