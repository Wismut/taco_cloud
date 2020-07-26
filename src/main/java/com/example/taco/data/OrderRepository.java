package com.example.taco.data;

import com.example.taco.Order;
import com.example.taco.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Mono<Order> save(Order order);

    Flux<Order> findByDeliveryZip(String deliveryZip);

    Flux<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
