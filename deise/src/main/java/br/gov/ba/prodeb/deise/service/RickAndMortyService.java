package br.gov.ba.prodeb.deise.service;

import br.gov.ba.prodeb.deise.client.RickAndMortyClient;
import br.gov.ba.prodeb.deise.dto.EpisodeDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RickAndMortyService {

    private RickAndMortyClient personagemClient;

    public RickAndMortyService(RickAndMortyClient personagemClient) {
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

    public PersonagemResponseDTO filtrar(String name, String status) {
        return personagemClient.filtrar(name, status);
    }

    public EpisodeDTO buscarPorEpisdio(int id) {
        return personagemClient.listaDeEp(id);
    }

    public EpisodeDTO buscarMultiplosepisdioPorId(String episode) {
        return personagemClient.buscarMultiplosEpsodios(episode);
    }
}
