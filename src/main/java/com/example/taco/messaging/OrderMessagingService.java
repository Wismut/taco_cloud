package com.example.taco.messaging;

import com.example.taco.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
