package com.example.taco.messaging;

import com.example.taco.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderMessagingService
        implements OrderMessagingService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaOrderMessagingService(
            KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(Order order) {
//        kafkaTemplate.send("tacocloud.orders.topic",
//                order.getId().toString(),
//                order.toString());
    }
}
