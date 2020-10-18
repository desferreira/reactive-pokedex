package br.com.diego.pokedex.pokedex;

import br.com.diego.pokedex.pokedex.data.model.Pokemon;
import br.com.diego.pokedex.pokedex.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class PokedexApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokedexApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ReactiveMongoOperations operations, PokemonRepository repository) {
        return args -> {
            Flux<Pokemon> pokemonFlux = Flux.just(
                    new Pokemon("Bulbassauro", "Semente", "OverGrow", 6.09),
                    new Pokemon("Charizard", "Fogo", "Blaze", 90.05),
                    new Pokemon("Caterpie", "Minhoca", "Poeira do Escudo", 2.09),
                    new Pokemon("Blastoise", "Marisco", "Torrente", 6.09)
            ).flatMap(repository::save);

            pokemonFlux.thenMany(repository.findAll()).subscribe(System.out::println);
        };
    }

}
