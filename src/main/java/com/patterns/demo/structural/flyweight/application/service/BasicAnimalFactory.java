package com.patterns.demo.structural.flyweight.application.service;

import com.patterns.demo.structural.flyweight.application.model.AnimalType;
import com.patterns.demo.structural.flyweight.application.model.GameObject;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
class BasicAnimalFactory {
    private final Map<AnimalType, GameObject> gameObjects = new ConcurrentHashMap<>();

    public GameObject getBasicAnimal(AnimalType animalType) {
        return gameObjects.computeIfAbsent(animalType, AnimalType::createBasicAnimal);
    }

}
