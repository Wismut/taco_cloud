package com.example.taco.data;

import com.example.taco.Taco;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Taco save(Taco design);

    List<Taco> findAll(Pageable page);
}
