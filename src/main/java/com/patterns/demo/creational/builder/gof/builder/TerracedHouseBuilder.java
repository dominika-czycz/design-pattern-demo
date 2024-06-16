package com.patterns.demo.creational.builder.gof.builder;

import com.patterns.demo.creational.builder.gof.model.TerracedHouse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TerracedHouseBuilder implements HouseBuilder<TerracedHouse> {

    private final HouseBuilder<TerracedHouse> subcontractorBuilder;

    @Override
    public void buildFoundation() {
        setFieldSpecificForTerracedHouse();
        subcontractorBuilder.buildFoundation();
    }

    private void setFieldSpecificForTerracedHouse() {
        subcontractorBuilder.getHouse().setFieldSpecificForTerracedHouse(2);
        log.info("Field specific for TerracedHouse {}", subcontractorBuilder.getHouse().getFieldSpecificForTerracedHouse());
    }

    @Override
    public void buildStructure() {
        subcontractorBuilder.buildStructure();
    }

    @Override
    public void buildRoof() {
        subcontractorBuilder.buildRoof();
    }

    @Override
    public void paintHouse() {
        subcontractorBuilder.paintHouse();
    }

    @Override
    public void furnishHouse() {
        subcontractorBuilder.furnishHouse();
    }

    @Override
    public TerracedHouse getFinishedHouse() {
        return subcontractorBuilder.getFinishedHouse();
    }

    @Override
    public TerracedHouse getHouse() {
        return this.subcontractorBuilder.getHouse();
    }

}
