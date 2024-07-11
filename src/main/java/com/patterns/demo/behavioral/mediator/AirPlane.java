package com.patterns.demo.behavioral.mediator;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

//Colleague
@Slf4j
@RequiredArgsConstructor
public final class AirPlane {

    @NonNull
    private final String registration;
    @Setter
    private ControlTower controlTower;

    public boolean land() {
        if (controlTower.requestLanding(this)) {
            log.info("Air plane {} is landing", registration);
            return true;
        }
        return false;
    }

    public void notifyAirTrafficControl(String message) {
        log.info("Air plane {} is notifying air traffic control with message {} ", registration, message);
    }


}
