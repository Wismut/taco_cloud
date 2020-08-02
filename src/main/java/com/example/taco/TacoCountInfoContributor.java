package com.example.taco;

import com.example.taco.data.TacoRepository;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TacoCountInfoContributor implements InfoContributor {
    private final TacoRepository tacoRepository;

    public TacoCountInfoContributor(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @Override
    public void contribute(Builder builder) {
        long tacoCount = tacoRepository.count().blockOptional().orElse(0L);
        Map<String, Object> tacoMap = new HashMap<>();
        tacoMap.put("count", tacoCount);
        builder.withDetail("taco-stats", tacoMap);
    }
}
