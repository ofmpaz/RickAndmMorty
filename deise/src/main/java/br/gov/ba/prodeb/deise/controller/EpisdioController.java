package br.gov.ba.prodeb.deise.controller;

import br.gov.ba.prodeb.deise.dto.EpisodeDTO;
import br.gov.ba.prodeb.deise.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodio")
public class EpisdioController {

    @Autowired
    private RickAndMortyService rickAndMortyService;

    @GetMapping("/{id}")
    public ResponseEntity<EpisodeDTO> episodiosComPersonagem(@PathVariable String id) {
        return ResponseEntity.ok(rickAndMortyService.buscarPorEpisdio(id));
    }

    @GetMapping("/multiplos/{ids}")
    public ResponseEntity<List<EpisodeDTO>> buscarEpMultiplos(@PathVariable("ids") String ids) {
        return ResponseEntity.ok(rickAndMortyService.buscarEpMultiplos(ids));
    }
}
