package br.gov.ba.prodeb.deise.entity;

import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Personagem {

    public Personagem(PersonagemDTO personagemDTO) {
        personagemId = personagemDTO.getId();
        name = personagemDTO.getName();
        status = personagemDTO.getStatus();
        species = personagemDTO.getSpecies();
    }

    public PersonagemDTO toDTO() {
        return new PersonagemDTO(id, personagemId, name, status, species);
    }


    @Id
    private String id;
    private String personagemId;
    private String name;
    private String status;
    private String species;


}
