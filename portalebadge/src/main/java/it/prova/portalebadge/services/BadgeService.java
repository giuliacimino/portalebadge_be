package it.prova.portalebadge.services;

import it.prova.portalebadge.model.Badge;

import java.util.List;

public interface BadgeService {
    public List<Badge> listAllBadges();
    public Badge getBadge(Long id);

    public Badge updateBadge(Badge badgeInstance);

    public Badge insertBadge(Badge badgeInstance);

    public void deleteBadge(Long id);





}
