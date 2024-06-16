package com.patterns.demo.creational.builder.gof.builder;

import com.patterns.demo.creational.builder.gof.model.DetachedHouse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DetachedHouseBuilder implements HouseBuilder<DetachedHouse> {
    private final HouseBuilder<DetachedHouse> subcontractorBuilder;

    @Override
    public void buildFoundation() {
        subcontractorBuilder.getHouse().setFieldSpecificForDetachedHouse(true);
        log.info("Field specific for DetachedHouse {}", subcontractorBuilder.getHouse().getFieldSpecificForDetachedHouse());
        subcontractorBuilder.buildFoundation();
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
    public DetachedHouse getFinishedHouse() {
        return subcontractorBuilder.getFinishedHouse();
    }

    @Override
    public DetachedHouse getHouse() {
        return this.subcontractorBuilder.getHouse();
    }

}
