package br.gov.ba.prodeb.deise.controller;

import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import br.gov.ba.prodeb.deise.service.CacheService;
import br.gov.ba.prodeb.deise.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @Autowired
    RickAndMortyService rickAndMortyService;

    @PostMapping("/tempo-expiracao")
    public ResponseEntity<Boolean> tempoExpiracao(@RequestParam String chave, @RequestParam Long time) {
         Boolean tempoExpiracao = cacheService.tempoExpiracaoCache(chave, time);

         if(tempoExpiracao != null) {
            return ResponseEntity.noContent().build();
         }else {
             return ResponseEntity.notFound().build();
         }
    }

    @PostMapping("/salvar-cache/{id}")
    public ResponseEntity<String> salvarCache(@PathVariable String id) {
        return ResponseEntity.ok(cacheService.salvaCache(id));
    }
}
