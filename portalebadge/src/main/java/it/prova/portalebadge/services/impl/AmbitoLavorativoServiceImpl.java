package it.prova.portalebadge.services.impl;


import it.prova.portalebadge.model.AmbitoLavorativo;
import it.prova.portalebadge.model.Badge;
import it.prova.portalebadge.repositories.AmbitoLavorativoRepository;
import it.prova.portalebadge.repositories.BadgeRepository;
import it.prova.portalebadge.services.AmbitoLavorativoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AmbitoLavorativoServiceImpl implements AmbitoLavorativoService {

    @Autowired
    private AmbitoLavorativoRepository repository;

    @Override
    public List<AmbitoLavorativo> listAllAmbitiLavorativi() {
        return (List<AmbitoLavorativo>) repository.findAll();

    }

    @Override
    public AmbitoLavorativo getAmbitoLavorativo(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public AmbitoLavorativo updateAmbitoLavorativo(AmbitoLavorativo ambitoLavorativoInstance) {
        return repository.save(ambitoLavorativoInstance);
    }

    @Override
    public AmbitoLavorativo insertAmbitoLavorativo(AmbitoLavorativo ambitoLavorativoInstance) {
        return repository.save(ambitoLavorativoInstance);
    }

    @Override
    public void deleteAmbitoLavorativo(Long id) {
        repository.deleteById(id);


    }
}
