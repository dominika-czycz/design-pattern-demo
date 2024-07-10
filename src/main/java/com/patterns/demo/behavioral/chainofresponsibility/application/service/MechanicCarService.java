package com.patterns.demo.behavioral.chainofresponsibility.application.service;

import com.patterns.demo.behavioral.chainofresponsibility.application.model.Car;

public class MechanicCarService extends CarService {

    @Override
    protected boolean shouldBeRepaired(Car car) {
        return !car.isMechanicSystemStateWorking();
    }

    @Override
    public void repair(Car car) {
        car.repairMechanicSystemState();
    }
}
