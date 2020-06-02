package com.example.taco.messaging;

import com.example.taco.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {
    private final KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @RabbitListener
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }
}
