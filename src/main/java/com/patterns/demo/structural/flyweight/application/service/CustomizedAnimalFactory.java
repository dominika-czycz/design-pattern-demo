package com.patterns.demo.structural.flyweight.application.service;

import com.patterns.demo.structural.flyweight.application.model.AnimalType;
import com.patterns.demo.structural.flyweight.application.model.BasicCat;
import com.patterns.demo.structural.flyweight.application.model.CustomizedCat;
import com.patterns.demo.structural.flyweight.application.model.GameObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomizedAnimalFactory {
    private final BasicAnimalFactory basicAnimalFactory;

    public GameObject createCustomizedCat(String name) {
        GameObject cat = basicAnimalFactory.getBasicAnimal(AnimalType.CAT);
        return new CustomizedCat(name, (BasicCat) cat);
    }

}
