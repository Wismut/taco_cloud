package com.example.taco.messaging;

import com.example.taco.Order;

public interface OrderReceiver {
    Order receiveOrder();
}
