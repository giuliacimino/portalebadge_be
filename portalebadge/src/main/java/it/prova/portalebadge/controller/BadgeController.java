package it.prova.portalebadge.controller;

import it.prova.portalebadge.dto.BadgeDTO;
import it.prova.portalebadge.model.Badge;
import it.prova.portalebadge.services.BadgeService;
import it.prova.portalebadge.services.impl.BadgeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badge")
@CrossOrigin
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    @GetMapping
    public List<BadgeDTO> listAllBadges() {
        return BadgeDTO.createBadgeDTOListFromModelList(badgeService.listAllBadges());
    }

    @GetMapping("/{id}")
    public BadgeDTO getBadge(@PathVariable(required = true, value = "id") Long id) {
        return BadgeDTO.buildBadgeDTOFromModel(badgeService.getBadge(id));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BadgeDTO insertBadge(@Valid @RequestBody BadgeDTO badgeInstance) {

        return BadgeDTO.buildBadgeDTOFromModel(badgeService.insertBadge(badgeInstance.buildBadgeModel()));

    }

    @PutMapping("/{id}")
    public BadgeDTO update(@Valid @RequestBody BadgeDTO badgeInstance,@PathVariable(required = true) Long id) {
        badgeInstance.setId(id);


        return BadgeDTO.buildBadgeDTOFromModel(badgeService.updateBadge(badgeInstance.buildBadgeModel()));

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(required = true) Long id) {
        badgeService.deleteBadge(id);
    }




}
