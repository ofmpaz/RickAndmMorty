package br.gov.ba.prodeb.deise.repository;

import br.gov.ba.prodeb.deise.entity.Personagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;


public interface PersonagemRepository extends MongoRepository<Personagem, String> {

    Optional<Personagem> findFirstByPersonagemId(String id);

}
