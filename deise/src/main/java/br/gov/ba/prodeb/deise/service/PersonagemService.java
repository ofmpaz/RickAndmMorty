package br.gov.ba.prodeb.deise.service;

import br.gov.ba.prodeb.deise.client.PersonagemClient;
import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonagemService {

    private PersonagemClient personagemClient;

    public PersonagemService(PersonagemClient personagemClient) {
        this.personagemClient = personagemClient;
    }

    public PersonagemResponseDTO obterTodos() {
        return personagemClient.obterTodos();
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
}
