package com.example.taco.web.api;

import com.example.taco.Ingredient;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

class IngredientResourceAssembler extends
        RepresentationModelAssemblerSupport<Ingredient, IngredientModel> {
    public IngredientResourceAssembler() {
        super(IngredientController2.class, IngredientModel.class);
    }

    @Override
    public IngredientModel toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientModel instantiateModel(
            Ingredient ingredient) {
        return new IngredientModel(ingredient);
    }
}
