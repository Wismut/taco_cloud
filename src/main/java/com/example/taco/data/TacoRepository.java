package com.example.taco.data;

import com.example.taco.Taco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TacoRepository extends ReactiveCrudRepository<Taco, String> {
    Mono<Taco> save(Mono<Taco> design);

//    PageImpl<Taco> findAll(Pageable page);
}
