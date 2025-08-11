package br.gov.ba.prodeb.deise.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonagemDTO {

    private String id;
    private String name;
    private String status;
    private String species;

}
