package com.example.taco.data;

import com.example.taco.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order save(Order order);

    List<Order> findByZip(String deliveryZip);
}
