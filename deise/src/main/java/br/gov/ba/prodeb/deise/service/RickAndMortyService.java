package br.gov.ba.prodeb.deise.service;

import br.gov.ba.prodeb.deise.client.RickAndMortyClient;
import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import br.gov.ba.prodeb.deise.entity.Personagem;
import br.gov.ba.prodeb.deise.mapper.PersonagemMapper;
import br.gov.ba.prodeb.deise.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RickAndMortyService {

    @Autowired
    private RickAndMortyClient personagemClient;

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    CacheService cacheService;

    private final String CACHE_KEY = "personagem:id:";

    public PersonagemDTO buscarPorId(String id) {
        String cacheKey = CACHE_KEY + id;
        PersonagemDTO personagemCache = (PersonagemDTO) cacheService.buscarCache(cacheKey);

        if (personagemCache == null) {
            personagemCache = personagemClient.obterPeloId(Integer.parseInt(id));
            cacheService.salvarCache(cacheKey, personagemCache);
        }

        return personagemCache;
    }

    public PersonagemResponseDTO obterTodos(int page) {
        return personagemClient.obterTodos(page);
    }

    public List<PersonagemDTO> obterMultiplosIds(String ids) {
        List<PersonagemDTO> personagensApi = personagemClient.obterMultiplosIds(ids);

        if (personagensApi == null || personagensApi.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum personagem encontrado para os IDs fornecidos.");
        }

        List<Personagem> entidades = personagensApi.stream()
                .map(PersonagemMapper::toEntity)
                .collect(Collectors.toList());

        personagemRepository.saveAll(entidades);

        return personagensApi;
    }

    public PersonagemResponseDTO filtrar(String name, String status, String species) {
        return personagemClient.filtrar(name, status, species);
    }

    public List<PersonagemDTO> buscarPorEspecie(String especie) {
        List<PersonagemDTO> personagensDaApi = personagemClient.filtrar(null, null, especie).getResults();

        List<Personagem> entidades = personagensDaApi.stream()
                .map(PersonagemMapper::toEntity)
                .collect(Collectors.toList());

        personagemRepository.saveAll(entidades);

        return personagensDaApi;
    }

    public PersonagemDTO atualizar(String id, String nome, String status, String especie) {
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado."));

        if (nome != null) {
            personagem.setName(nome);
        }
        if (status != null) {
            personagem.setStatus(status);
        }
        if(especie != null) {
            personagem.setSpecies(especie);
        }
        
        Personagem personagemAtualizado = personagemRepository.save(personagem);
        return personagemAtualizado.toDTO();
    }




}
