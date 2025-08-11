package br.gov.ba.prodeb.deise.mapper;

import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.entity.Personagem;

public class PersonagemMapper {

    public static Personagem toEntity(PersonagemDTO dto) {
        Personagem personagem = new Personagem();
        personagem.setPersonagemId(dto.getId());
        personagem.setName(dto.getName());
        personagem.setSpecies(dto.getSpecies());
        personagem.setStatus(dto.getStatus());
        return personagem;
    }

    public static PersonagemDTO toDto(Personagem personagem) {
        PersonagemDTO dto = new PersonagemDTO();
        dto.setId(personagem.getPersonagemId());
        dto.setName(personagem.getName());
        dto.setStatus(personagem.getStatus());
        dto.setSpecies(personagem.getSpecies());
        return dto;
    }
}
