package com.example.taco.web.api;

import com.example.taco.Taco;
import com.example.taco.web.DesignTacoController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class TacoResourceAssembler
        extends ResourceAssemblerSupport<Taco, TacoResource> {
    public TacoResourceAssembler() {
        super(DesignTacoController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateResource(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toResource(Taco taco) {
        return createResourceWithId(taco.getId(), taco);
    }
}
