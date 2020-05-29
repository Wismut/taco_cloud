package com.example.taco.data;

import com.example.taco.Taco;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Taco save(Taco design);

    PageImpl<Taco> findAll(Pageable page);
}
