package com.example.taco.data;

import com.example.taco.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {
    Flux<Ingredient> findAll();

    Mono<Ingredient> findById(String id);

    Mono save(Ingredient ingredient);
}
