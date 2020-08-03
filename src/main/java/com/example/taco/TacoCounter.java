package com.example.taco;

import com.example.taco.data.TacoRepository;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@ManagedResource
public class TacoCounter extends AbstractRepositoryEventListener<Taco> {
    private final AtomicLong counter;

    public TacoCounter(TacoRepository tacoRepo) {
        long initialCount = tacoRepo.count().blockOptional().orElse(0L);
        this.counter = new AtomicLong(initialCount);
    }

    @Override
    protected void onAfterCreate(Taco taco) {
        counter.incrementAndGet();
    }

    @ManagedAttribute
    public long getTacoCount() {
        return counter.get();
    }

    @ManagedOperation
    public long increment(long delta) {
        return counter.addAndGet(delta);
    }
}
