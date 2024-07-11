package com.patterns.demo.behavioral.mediator;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


class ControlTowerTest {
    @Test
    void tenPlanesShouldLand() {
        // given
        ControlTower controlTower = new ControlTower();
        List<AirPlane> airPlanes = IntStream.range(0, 10).mapToObj(i -> new AirPlane("ABC" + i)).toList();

        airPlanes.forEach(airPlane -> airPlane.setControlTower(controlTower));

        // when
        List<Boolean> result = airPlanes.stream().map(AirPlane::land).toList();

        // then
        assertThat(result).containsOnly(true);
    }

    @Test
    void elevenPlanesShouldNotLand() {
        // given
        ControlTower controlTower = new ControlTower();
        List<AirPlane> airPlanes = IntStream.range(0, 11).mapToObj(i -> new AirPlane("ABC" + i)).toList();

        airPlanes.forEach(airPlane -> airPlane.setControlTower(controlTower));

        // when
        List<Boolean> result = airPlanes.stream().map(AirPlane::land).toList();

        // then
        assertThat(result).contains(false);
    }
}
