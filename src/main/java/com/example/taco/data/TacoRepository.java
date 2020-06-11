package com.example.taco.data;

import com.example.taco.Taco;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TacoRepository extends ReactiveCrudRepository<Taco, Long> {
    Mono<Taco> save(Taco design);

    PageImpl<Taco> findAll(Pageable page);
}
