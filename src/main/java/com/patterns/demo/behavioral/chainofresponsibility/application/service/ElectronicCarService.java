package com.patterns.demo.behavioral.chainofresponsibility.application.service;

import com.patterns.demo.behavioral.chainofresponsibility.application.model.Car;

public class ElectronicCarService extends CarService {


    @Override
    protected boolean shouldBeRepaired(Car car) {
        return !car.isElectronicSystemStateWorking();
    }

    @Override
    public void repair(Car car) {
        car.repairElectronicSystemState();
    }
}
