package com.example.taco;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(Taco.class)
public class TacoEventHandler {
    @HandleBeforeCreate
    public void handleTacoBeforeCreate(Taco taco) {
        System.out.println("Taco: " + taco.getName());
    }
}
