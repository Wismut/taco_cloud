package com.example.taco.web.api;

import com.example.taco.Taco;
import com.example.taco.web.DesignTacoController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoResourceAssembler
        extends RepresentationModelAssemblerSupport<Taco, TacoResource> {
    public TacoResourceAssembler() {
        super(DesignTacoController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateModel(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toModel(Taco taco) {
        return createModelWithId(taco.getId(), taco);
    }
}
