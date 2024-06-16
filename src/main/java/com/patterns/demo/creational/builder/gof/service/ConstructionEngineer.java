package com.patterns.demo.creational.builder.gof.service;

import com.patterns.demo.creational.builder.gof.builder.HouseBuilder;
import com.patterns.demo.creational.builder.gof.model.House;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConstructionEngineer {
    private final HouseBuilder<?> houseBuilder;

    public House constructHouse() {
        this.houseBuilder.buildFoundation();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.paintHouse();
        this.houseBuilder.furnishHouse();
        return this.houseBuilder.getFinishedHouse();
    }
}
