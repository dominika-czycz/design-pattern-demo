package com.patterns.demo.behavioral.chainofresponsibility.application.service;

import com.patterns.demo.behavioral.chainofresponsibility.application.model.Car;
import com.patterns.demo.behavioral.chainofresponsibility.application.model.UnrepairedCarException;

import java.util.Optional;


public abstract class CarService {
    private CarService next;

    public void handle(Car car) {
        if (shouldBeRepaired(car)) {
            repair(car);
        }

        if (!car.isWorking()) {
            Optional.ofNullable(next)
                    .orElseThrow(UnrepairedCarException::new)
                    .handle(car);
        }
    }

    protected abstract boolean shouldBeRepaired(Car car);

    public abstract void repair(Car car);

    public void setNext(CarService next) {
        if (this != next) {
            this.next = next;
        } else {
            throw new IllegalArgumentException("The next service cannot be the same instance as the current service");
        }
    }
}
