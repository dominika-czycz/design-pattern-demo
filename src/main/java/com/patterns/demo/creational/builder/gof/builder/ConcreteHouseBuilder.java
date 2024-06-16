package com.patterns.demo.creational.builder.gof.builder;

import com.patterns.demo.creational.builder.gof.model.House;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record ConcreteHouseBuilder<HOUSE extends House>(HOUSE house) implements HouseBuilder<HOUSE> {
    @Override
    public void buildFoundation() {
        house.setFoundation("Concrete, brick, and stone");
        log.info("ConcreteHouseBuilder: Foundation complete...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Concrete, mortar, brick, and reinforced steel");
        log.info("ConcreteHouseBuilder: Structure complete...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Concrete and reinforced steel");
        log.info("ConcreteHouseBuilder: Roof complete...");
    }

    @Override
    public void paintHouse() {
        house.setPainted(true);
        log.info("ConcreteHouseBuilder: Painting complete...");
    }

    @Override
    public void furnishHouse() {
        house.setFurnished(true);
        log.info("ConcreteHouseBuilder: Furnishing complete...");
    }

    @Override
    public HOUSE getFinishedHouse() {
        log.info("ConcreteHouseBuilder: Concrete house complete...");
        return this.house;
    }

    @Override
    public HOUSE getHouse() {
        return this.house;
    }

}
