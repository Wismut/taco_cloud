package com.example.taco.web.api;

import com.example.taco.Ingredient;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

public class IngredientResource extends ResourceSupport {
    @Getter
    private String name;

    @Getter
    private Ingredient.Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
