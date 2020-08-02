package com.example.taco;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TacoMetrics extends AbstractRepositoryEventListener<Taco> {
    private final MeterRegistry meterRegistry;

    public TacoMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    protected void onAfterCreate(Taco taco) {
        List<Ingredient> ingredients = taco.getIngredients();
        for (Ingredient ingredient : ingredients) {
            meterRegistry.counter("tacoCloud",
                    "ingredient", ingredient.getId()).increment();
        }
    }
}
