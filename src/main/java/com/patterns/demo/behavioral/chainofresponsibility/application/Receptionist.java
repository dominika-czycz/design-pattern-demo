package com.patterns.demo.behavioral.chainofresponsibility.application;

import com.patterns.demo.behavioral.chainofresponsibility.application.model.Car;
import com.patterns.demo.behavioral.chainofresponsibility.application.service.CarService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Receptionist {
    @NonNull
    private final CarService firstSpecialist;

    public void arrangeCarRepair(Car car) {
        firstSpecialist.handle(car);
    }
}
