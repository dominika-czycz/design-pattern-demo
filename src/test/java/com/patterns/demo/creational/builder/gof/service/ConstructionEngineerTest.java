package com.patterns.demo.creational.builder.gof.service;


import com.patterns.demo.creational.builder.gof.builder.ConcreteHouseBuilder;
import com.patterns.demo.creational.builder.gof.builder.DetachedHouseBuilder;
import com.patterns.demo.creational.builder.gof.builder.HouseBuilder;
import com.patterns.demo.creational.builder.gof.builder.PrefabicatedHouseBuilder;
import com.patterns.demo.creational.builder.gof.builder.TerracedHouseBuilder;
import com.patterns.demo.creational.builder.gof.model.DetachedHouse;
import com.patterns.demo.creational.builder.gof.model.House;
import com.patterns.demo.creational.builder.gof.model.TerracedHouse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConstructionEngineerTest {

    @Test
    void shouldCreateConcreteTerracedHouse() {
        HouseBuilder<TerracedHouse> concreteHouseBuilder = new TerracedHouseBuilder(new ConcreteHouseBuilder<>(new TerracedHouse()));
        ConstructionEngineer constructionEngineer = new ConstructionEngineer(concreteHouseBuilder);
        House house = constructionEngineer.constructHouse();
        assertThat(house).isInstanceOf(TerracedHouse.class);
        TerracedHouse terracedHouse = (TerracedHouse) house;
        assertThat(terracedHouse.isFurnished()).isTrue();
        assertThat(terracedHouse.isPainted()).isTrue();
        assertThat(terracedHouse.getFoundation()).isNotBlank();
        assertThat(terracedHouse.getStructure()).isNotBlank();
        assertThat(terracedHouse.getRoof()).isNotBlank();
        assertThat(terracedHouse.getFieldSpecificForTerracedHouse()).isNotNull();
    }

    @Test
    void shouldCreateConcreteDetachedHouse() {
        HouseBuilder<DetachedHouse> prefabricatedDetachedHouseBuilder = new DetachedHouseBuilder(new PrefabicatedHouseBuilder<>(new DetachedHouse()));
        ConstructionEngineer constructionEngineer = new ConstructionEngineer(prefabricatedDetachedHouseBuilder);
        House house = constructionEngineer.constructHouse();
        assertThat(house).isInstanceOf(DetachedHouse.class);
        DetachedHouse detachedHouse = (DetachedHouse) house;
        assertThat(detachedHouse.isFurnished()).isTrue();
        assertThat(detachedHouse.isPainted()).isFalse();
        assertThat(detachedHouse.getFoundation()).isNotBlank();
        assertThat(detachedHouse.getStructure()).isNotBlank();
        assertThat(detachedHouse.getRoof()).isNotBlank();
        assertThat(detachedHouse.getFieldSpecificForDetachedHouse()).isTrue();
    }
}
