package com.patterns.demo.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class BaristaEquipmentIntegrationTest {

    @Test
    void shouldPrepareDeliciousCoffee() {
        // given
        SyrupDispenserEquipment barista = new SyrupDispenserEquipment(
                new IceCreamEquipment(
                        new SteamedMilkEquipment(
                                new EspressoMachine()
                        )
                )
        );

        // when
        Coffee coffee = barista.makeCoffee();

        // then
        assertThat(coffee).isNotNull()
                .extracting(Coffee::getEspresso)
                .isNotNull().isEqualTo(true);
        assertThat(coffee).extracting(Coffee::getHotWater).isNotNull().isEqualTo(true);
        assertThat(coffee).extracting(Coffee::getIceCream).isNotNull().isEqualTo(true);
        assertThat(coffee).extracting(Coffee::getSteamedMilk).isNotNull().isEqualTo(true);
        assertThat(coffee).extracting(Coffee::getSyrup).isNotNull().isEqualTo(true);

    }
}
