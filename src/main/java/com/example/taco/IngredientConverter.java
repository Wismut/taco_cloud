package com.example.taco;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientConverter implements Converter<String, Ingredient> {
    @Override
    public Ingredient convert(String ingredientId) {
        return new Ingredient(ingredientId, ingredientId + "name", Ingredient.Type.PROTEIN);
    }
}
