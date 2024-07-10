package com.patterns.demo.behavioral.chainofresponsibility.application.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Car {
    @NonNull
    private final String licensePlateNumber;
    @NonNull
    private final String model;

    @NonNull
    @Setter
    private ElementsState electronicSystemState;
    @NonNull
    @Setter
    private ElementsState mechanicSystemState;

    public boolean isWorking() {
        return isMechanicSystemStateWorking() && isElectronicSystemStateWorking();
    }

    public boolean isMechanicSystemStateWorking() {
        return mechanicSystemState != ElementsState.NOT_WORKING;
    }

    public boolean isElectronicSystemStateWorking() {
        return electronicSystemState != ElementsState.NOT_WORKING;
    }

    public void repairElectronicSystemState() {
        this.electronicSystemState = ElementsState.GOOD;
    }

    public void repairMechanicSystemState() {
        this.mechanicSystemState = ElementsState.GOOD;
    }

}
