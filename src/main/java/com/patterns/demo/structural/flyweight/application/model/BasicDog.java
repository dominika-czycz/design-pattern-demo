package com.patterns.demo.structural.flyweight.application.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record BasicDog(@NonNull String breed /* and many other parameters here...*/) implements GameObject {
    @Override
    public void render() {
        log.info("Rendering a {} with breed {} ", getObjectType(), breed);
    }

    @Override
    public AnimalType getObjectType() {
        return AnimalType.DOG;
    }
}
