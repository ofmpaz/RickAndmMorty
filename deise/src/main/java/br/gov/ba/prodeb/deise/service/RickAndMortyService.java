package br.gov.ba.prodeb.deise.service;

import br.gov.ba.prodeb.deise.client.RickAndMortyClient;
import br.gov.ba.prodeb.deise.dto.EpisodeDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import br.gov.ba.prodeb.deise.entity.Personagem;
import br.gov.ba.prodeb.deise.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RickAndMortyService {

    @Autowired
    private RickAndMortyClient personagemClient;
    @Autowired
    private PersonagemRepository personagemRepository;

    public PersonagemResponseDTO obterTodos(int page) {
        return personagemClient.obterTodos(page);
    }

    /*public PersonagemDTO buscarPorId(int id) {
        PersonagemDTO dto = personagemClient.obterPeloId(id);
        Personagem personagem = new Personagem(dto);
        personagemRepository.save(personagem);
        return dto;
    }*/

    public PersonagemDTO buscarPorId(String id) {
        Optional<Personagem> personagemCache = personagemRepository.findFirstByPersonagemId(id);
        if (personagemCache.isPresent()) {
            PersonagemDTO personagemDTO = new PersonagemDTO();
            return personagemCache.get().toDTO();
        }
        PersonagemDTO dto = personagemClient.obterPeloId(Integer.parseInt(id));
        Personagem personagem = new Personagem(dto);
        personagemRepository.save(personagem);
        return dto;
    }


    public List<PersonagemDTO> obterMultiplosIds(String ids) {
        return personagemClient.obterMultiplosIds(ids);
    }

    public PersonagemResponseDTO filtrar(String name, String status) {
        return personagemClient.filtrar(name, status);
    }

    public EpisodeDTO buscarPorEpisdio(String id) {
        return personagemClient.listaDeEp(id);
    }

    public List<EpisodeDTO> buscarEpMultiplos(String ids) {
        return personagemClient.buscarEpMultiplos(ids);
    }
}
