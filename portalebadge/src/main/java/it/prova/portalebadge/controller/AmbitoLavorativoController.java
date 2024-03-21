package it.prova.portalebadge.controller;

import it.prova.portalebadge.dto.AmbitoLavorativoDTO;
import it.prova.portalebadge.dto.BadgeDTO;
import it.prova.portalebadge.services.AmbitoLavorativoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ambitoLavorativo")
@CrossOrigin
public class AmbitoLavorativoController {
    @Autowired
    private AmbitoLavorativoService ambitoLavorativoService;

    @GetMapping
    public List<AmbitoLavorativoDTO> listAllAmbitiLavorativi() {
        return AmbitoLavorativoDTO.createAmbitoLavorativoDTOListFromModelList(ambitoLavorativoService.listAllAmbitiLavorativi());
    }

    @GetMapping("/{id}")
    public AmbitoLavorativoDTO getAmbitoLavorativo(@PathVariable(required = true, value = "id") Long id) {
        return AmbitoLavorativoDTO.buildAmbitoLavorativoDTOFromModel(ambitoLavorativoService.getAmbitoLavorativo(id));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AmbitoLavorativoDTO insertAmbitoLavorativo(@Valid @RequestBody AmbitoLavorativoDTO ambitoLavorativoInstance) {

        return AmbitoLavorativoDTO.buildAmbitoLavorativoDTOFromModel(ambitoLavorativoService.insertAmbitoLavorativo(ambitoLavorativoInstance.buildAmbitoLavorativoModel()));

    }

    @PutMapping("/{id}")
    public AmbitoLavorativoDTO update(@Valid @RequestBody AmbitoLavorativoDTO ambitoLavorativoInstance,@PathVariable(required = true) Long id) {
        ambitoLavorativoInstance.setId(id);


        return AmbitoLavorativoDTO.buildAmbitoLavorativoDTOFromModel(ambitoLavorativoService.updateAmbitoLavorativo(ambitoLavorativoInstance.buildAmbitoLavorativoModel()));

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(required = true) Long id) {
        ambitoLavorativoService.deleteAmbitoLavorativo(id);
    }


}
