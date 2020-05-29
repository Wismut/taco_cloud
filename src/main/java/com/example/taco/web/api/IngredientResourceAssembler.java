package com.example.taco.web.api;

import com.example.taco.Ingredient;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

class IngredientResourceAssembler extends
        ResourceAssemblerSupport<Ingredient, IngredientResource> {
    public IngredientResourceAssembler() {
        super(IngredientController2.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return createResourceWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientResource instantiateResource(
            Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }
}
