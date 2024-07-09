package com.patterns.demo.structural.decorator;

public class SyrupDispenserEquipment extends BaristaEquipment {
    public SyrupDispenserEquipment(CoffeeMaker coffeeMaker) {
        super(coffeeMaker);
    }

    @Override
    public Coffee makeCoffee() {
        Coffee coffee = this.getCoffeeMaker().makeCoffee();
        coffee.setSyrup(true);
        return coffee;
    }
}
