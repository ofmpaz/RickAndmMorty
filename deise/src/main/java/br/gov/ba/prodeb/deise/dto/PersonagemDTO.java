package br.gov.ba.prodeb.deise.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonagemDTO {

    private String id;
    private String name;
    private String status;
    private String species;

    /*public PersonagemDTO( String name, String status, String species) {
        this.name = name;
        this.status = status;
        this.species = species;
    }*/
}
