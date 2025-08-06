package br.gov.ba.prodeb.deise.controller;

import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.dto.PersonagemResponseDTO;
import br.gov.ba.prodeb.deise.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping("/personagem")
    public ResponseEntity<PersonagemResponseDTO> obterTodos() {
        return ResponseEntity.ok(personagemService.obterTodos());
    }

    @GetMapping("/personagem/{id}")
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
}
