package br.gov.ba.prodeb.deise.service;

import br.gov.ba.prodeb.deise.dto.PersonagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class CacheService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    RickAndMortyService rickAndMortyService;

    private final String CACHE_KEY = "personagem:id:";

    public void salvarCache(String chave, Object valor) {
        redisTemplate.opsForValue().set(chave, valor);
    }

    public Object buscarCache(String chave) {
        return redisTemplate.opsForValue().get(chave);
    }

    public void deletarCache(String chave) {
        redisTemplate.opsForValue().getAndDelete(chave);
    }

    public Boolean tempoExpiracaoCache(String chave,Long time) {
        Boolean chaveExiste = redisTemplate.hasKey(chave);
        if(chaveExiste.booleanValue()) {
             return redisTemplate.expire(chave, Duration.ofSeconds(time));
        }
        return false;
    }

    public String salvaCache(String id) {
        String cacheKey = CACHE_KEY + id;
        PersonagemDTO personagemCache = rickAndMortyService.buscarPorId(id);
        if (personagemCache != null) {
            salvarCache(cacheKey, personagemCache);
            return cacheKey;
        }
        return "Usuário não existe na API";
    }
}
