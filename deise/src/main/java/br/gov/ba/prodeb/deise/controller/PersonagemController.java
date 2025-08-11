package br.gov.ba.prodeb.deise.controller;

import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import br.gov.ba.prodeb.deise.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagem")
public class PersonagemController {

    @Autowired
    private RickAndMortyService rickAndMortyService;

    @GetMapping
    public ResponseEntity<PersonagemResponseDTO> obterTodos(@RequestParam(required = false, defaultValue = "1") int page) {
        return ResponseEntity.ok(rickAndMortyService.obterTodos(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> obterPorId(@PathVariable String id) {
        return ResponseEntity.ok(rickAndMortyService.buscarPorId(id));
    }

    @GetMapping("/multiplos/{ids}")
    public ResponseEntity<List<PersonagemDTO>> obterMultiplosIds(@PathVariable String ids) {
        return ResponseEntity.ok(rickAndMortyService.obterMultiplosIds(ids));
    }

    @GetMapping("/filtrar")
    public ResponseEntity<PersonagemResponseDTO> filtrar(@RequestParam (required = false) String name,
                                                         @RequestParam (required = false, defaultValue = "alive") String status,
                                                         @RequestParam (required = false) String species) {
        return ResponseEntity.ok(rickAndMortyService.filtrar(name, status, species));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PersonagemDTO> atualizar(@PathVariable String id, @RequestBody PersonagemDTO dto) {
        PersonagemDTO personagemAtualizado = rickAndMortyService.atualizar(
                id,
                dto.getName(),
                dto.getStatus(),
                dto.getSpecies()
        );
        return ResponseEntity.ok(personagemAtualizado);
    }
}
