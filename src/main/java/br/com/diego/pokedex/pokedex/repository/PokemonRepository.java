package br.com.diego.pokedex.pokedex.repository;

import br.com.diego.pokedex.pokedex.data.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String> {
}
