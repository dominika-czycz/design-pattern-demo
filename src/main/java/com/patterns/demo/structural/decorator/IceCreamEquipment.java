package com.patterns.demo.structural.decorator;

public class IceCreamEquipment extends BaristaEquipment {
    public IceCreamEquipment(CoffeeMaker coffeeMaker) {
        super(coffeeMaker);
    }

    @Override
    public Coffee makeCoffee() {
        Coffee coffee = this.getCoffeeMaker().makeCoffee();
        coffee.setIceCream(true);
        return coffee;
    }
}
