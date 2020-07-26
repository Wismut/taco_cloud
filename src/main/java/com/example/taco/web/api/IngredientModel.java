package com.example.taco.web.api;

import com.example.taco.Ingredient;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

public class IngredientModel extends RepresentationModel<IngredientModel> {
    @Getter
    private String name;

    @Getter
    private Ingredient.Type type;

    public IngredientModel(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
