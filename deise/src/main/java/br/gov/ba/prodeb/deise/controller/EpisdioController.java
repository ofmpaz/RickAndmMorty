package br.gov.ba.prodeb.deise.controller;

import br.gov.ba.prodeb.deise.dto.EpisodeDTO;
import br.gov.ba.prodeb.deise.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/episdio")
public class EpisdioController {

    @Autowired
    private RickAndMortyService rickAndMortyService;

    @GetMapping("/episodios/{id}")
    public ResponseEntity<EpisodeDTO> episodiosComPersonagem(@PathVariable int id) {
        return ResponseEntity.ok(rickAndMortyService.buscarPorEpisdio(id));
    }

    @GetMapping("/multiplos-episodios")
    public ResponseEntity<EpisodeDTO> buscarMultiplosEpsodios(@RequestParam String episode) {
        return ResponseEntity.ok(rickAndMortyService.buscarMultiplosepisdioPorId(episode));
    }
}
