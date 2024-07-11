package com.patterns.demo.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

//Mediator
public class ControlTower {
    public static final int AIR_PORT_LIMIT = 10;
    private final List<AirPlane> airPlanesAtTheAirport = new ArrayList<>();

    public boolean requestLanding(AirPlane airPlane) {
        // Business logic for coordinating landing
        if (airPlanesAtTheAirport.size() >= AIR_PORT_LIMIT) {
            return false;
        }
        airPlane.notifyAirTrafficControl("Requesting landing clearance.");
        return airPlanesAtTheAirport.add(airPlane);
    }
}
