package br.gov.ba.prodeb.deise.client;

import br.gov.ba.prodeb.deise.dto.EpisodeDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name ="personagem", url = "https://rickandmortyapi.com")
public interface RickAndMortyClient {

    @GetMapping("/api/character")
    PersonagemResponseDTO obterTodos(@RequestParam int page);

    @GetMapping("/api/character/{id}")
    PersonagemDTO obterPeloId(@PathVariable("id") int id);

    @GetMapping("/api/character/{ids}")
    List<PersonagemDTO> obterMultiplosIds(@PathVariable("ids") String ids);

    @GetMapping("/api/character")
    PersonagemResponseDTO filtrar(@RequestParam String name);

    @GetMapping("/api/episode/{id}")
    EpisodeDTO listaDeEp(@PathVariable int id);

    @GetMapping("/api/episode")
    EpisodeDTO buscarMultiplosEpsodios(@RequestParam String episode);
}
