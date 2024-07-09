package com.patterns.demo.structural.decorator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter(AccessLevel.PROTECTED)
@RequiredArgsConstructor
public abstract class BaristaEquipment implements CoffeeMaker {
    private final CoffeeMaker coffeeMaker;
}
