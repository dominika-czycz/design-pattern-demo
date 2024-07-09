package com.patterns.demo.structural.decorator;

public class SteamedMilkEquipment extends BaristaEquipment {
    public SteamedMilkEquipment(CoffeeMaker coffeeMaker) {
        super(coffeeMaker);
    }

    @Override
    public Coffee makeCoffee() {
        Coffee coffee = this.getCoffeeMaker().makeCoffee();
        coffee.setSteamedMilk(true);
        return coffee;
    }
}
