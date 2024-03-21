package it.prova.portalebadge.dto;


import it.prova.portalebadge.model.AmbitoLavorativo;
import it.prova.portalebadge.model.Badge;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmbitoLavorativoDTO {
    private Long id;
    private String descrizione;

    public AmbitoLavorativo buildAmbitoLavorativoModel() {
        return AmbitoLavorativo.builder()
                .id(id)
                .descrizione(descrizione)
                .build();
    }

    public static AmbitoLavorativoDTO buildAmbitoLavorativoDTOFromModel(AmbitoLavorativo ambitoLavorativoModel) {

        AmbitoLavorativoDTO result = AmbitoLavorativoDTO.builder().id(ambitoLavorativoModel.getId()).descrizione(ambitoLavorativoModel.getDescrizione())
                .build();

        return result;
    }


    public static List<AmbitoLavorativoDTO> createAmbitoLavorativoDTOListFromModelList(List<AmbitoLavorativo> modelListInput) {
        return modelListInput.stream().map(inputEntity -> {
            return AmbitoLavorativoDTO.buildAmbitoLavorativoDTOFromModel(inputEntity);
        }).collect(Collectors.toList());
    }
}


