package com.patterns.demo.creational.builder.gof.builder;

import com.patterns.demo.creational.builder.gof.model.House;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record PrefabicatedHouseBuilder<HOUSE extends House>(HOUSE house) implements HouseBuilder<HOUSE> {
    @Override
    public void buildFoundation() {
        house.setFoundation("Wood, laminate, and PVC flooring");
        log.info("PrefabricatedHouseBuilder: Foundation complete...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Structural steels and wooden wall panels");
        log.info("PrefabricatedHouseBuilder: Structure complete...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Roofing sheets");
        log.info("PrefabricatedHouseBuilder: Roof complete...");
    }

    @Override
    public void paintHouse() {
        house.setPainted(false);
        log.info("PrefabricatedHouseBuilder: Painting complete...");
    }

    @Override
    public void furnishHouse() {
        house.setFurnished(true);
        log.info("PrefabricatedHouseBuilder: Furnishing complete...");
    }

    @Override
    public HOUSE getFinishedHouse() {
        log.info("PrefabricatedHouseBuilder: Concrete house complete...");
        return this.house;
    }

    @Override
    public HOUSE getHouse() {
        return this.house;
    }

}
