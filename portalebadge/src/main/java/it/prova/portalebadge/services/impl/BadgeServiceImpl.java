package it.prova.portalebadge.services.impl;


import it.prova.portalebadge.model.Badge;
import it.prova.portalebadge.repositories.BadgeRepository;
import it.prova.portalebadge.services.BadgeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {

    @Autowired
    private BadgeRepository repository;
    @Override
    public List<Badge> listAllBadges() {
        return (List<Badge>) repository.findAll();
    }

    @Override
    public Badge getBadge(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Badge updateBadge(Badge badgeInstance) {
        return repository.save(badgeInstance);
    }

    @Override
    public Badge insertBadge(Badge badgeInstance) {
        return repository.save(badgeInstance);
    }

    @Override
    public void deleteBadge(Long id) {
        repository.deleteById(id);
    }
}
