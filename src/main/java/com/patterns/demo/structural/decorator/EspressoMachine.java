package com.patterns.demo.structural.decorator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EspressoMachine implements CoffeeMaker {
    @Override
    public Coffee makeCoffee() {
        Coffee coffee = new Coffee();
        coffee.setEspresso(true);
        coffee.setHotWater(true);
        return coffee;
    }
}
