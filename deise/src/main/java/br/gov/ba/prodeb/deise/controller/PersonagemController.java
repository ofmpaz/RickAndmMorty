package br.gov.ba.prodeb.deise.controller;

import br.gov.ba.prodeb.deise.dto.EpisodeDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import br.gov.ba.prodeb.deise.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<PersonagemResponseDTO> obterTodos(@RequestParam(required = false, defaultValue = "1") int page) {
        return ResponseEntity.ok(personagemService.obterTodos(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> obterPorId(@PathVariable int id) {
        return ResponseEntity.ok(personagemService.buscarPorId(id));
    }

    @GetMapping("/multiplos/{ids}")
    public ResponseEntity<List<PersonagemDTO>> obterMultiplosIds(@PathVariable String ids) {
       return ResponseEntity.ok(personagemService.obterMultiplosIds(ids));

    }

    @GetMapping("/filtrar")
    public ResponseEntity<PersonagemResponseDTO> filtrar(@RequestParam String name) {
        return ResponseEntity.ok(personagemService.filtrar(name));
    }

    @GetMapping("/epsodios/{id}")
    public ResponseEntity<EpisodeDTO> epsodiosComPersonagem(@PathVariable int id) {
        return ResponseEntity.ok(personagemService.buscarEpsodios(id));
    }

    @GetMapping("/multiplos-epsodios")
    public ResponseEntity<EpisodeDTO> buscarMultiplosEpsodios(@RequestParam String episode) {
        return ResponseEntity.ok(personagemService.buscarMultiplosEpsodios(episode));
    }
}
