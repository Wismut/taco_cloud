package com.example.taco.messaging;

import com.example.taco.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service
public class JmsOrderMessagingService implements OrderMessagingService {
    private final JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendOrder(Order order) {
        jms.send(session -> session.createObjectMessage(order));
    }
}
