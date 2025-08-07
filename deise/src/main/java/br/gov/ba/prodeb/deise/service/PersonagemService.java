package br.gov.ba.prodeb.deise.service;

import br.gov.ba.prodeb.deise.client.RickAndMortyClient;
import br.gov.ba.prodeb.deise.dto.EpisodeDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    private RickAndMortyClient personagemClient;

    public PersonagemService(RickAndMortyClient personagemClient) {
        this.personagemClient = personagemClient;
    }

    public PersonagemResponseDTO obterTodos(int page) {
        return personagemClient.obterTodos(page);
    }

    public PersonagemDTO buscarPorId(int id) {
        return personagemClient.obterPeloId(id);
    }

    public List<PersonagemDTO> obterMultiplosIds(String ids) {
       return personagemClient.obterMultiplosIds(ids);
    }

    public PersonagemResponseDTO filtrar(String name) {
        return personagemClient.filtrar(name);
    }

    public EpisodeDTO buscarEpsodios(int id) {
        return personagemClient.listaDeEp(id);
    }

    public EpisodeDTO buscarMultiplosEpsodios(String episode) {
        return personagemClient.buscarMultiplosEpsodios(episode);
    }
}
