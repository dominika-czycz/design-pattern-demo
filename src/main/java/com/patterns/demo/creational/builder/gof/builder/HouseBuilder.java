package com.patterns.demo.creational.builder.gof.builder;

import com.patterns.demo.creational.builder.gof.model.House;

public interface HouseBuilder<HOUSE extends House> {
    void buildFoundation();

    void buildStructure();

    void buildRoof();

    void paintHouse();

    void furnishHouse();

    HOUSE getFinishedHouse();

    HOUSE getHouse();
}
