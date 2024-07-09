package com.patterns.demo.structural.flyweight.application.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record CustomizedCat(@NonNull String name, @NonNull BasicCat basicCat) implements GameObject {
    @Override
    public void render() {
        log.info("Rendering a {} {} with name {}", basicCat.breed(), getObjectType(), name);
    }

    @Override
    public AnimalType getObjectType() {
        return AnimalType.CAT;
    }
}
