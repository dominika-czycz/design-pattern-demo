package com.patterns.demo.behavioral.state.first;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TVTest {

    @Test
    void shouldTurnOn() {
        // given
        TV tv = new TV("tvModel");

        // when
        tv.pressOnButton();

        // then
        assertThat(tv).extracting(TV::getTVMode)
                .isEqualTo(TVMode.ON);
    }

    @Test
    void shouldTurnOff() {
        // given
        TV tv = new TV("tvModel");
        tv.pressOnButton();

        // when
        tv.pressOffButton();

        // then
        assertThat(tv).extracting(TV::getTVMode)
                .isEqualTo(TVMode.OFF);
    }

    @Test
    void shouldBeInSleepMode() {
        // given
        TV tv = new TV("tvModel");
        tv.pressOnButton();

        // when
        tv.pressSleepButton();

        // then
        assertThat(tv).extracting(TV::getTVMode)
                .isEqualTo(TVMode.SLEEP);
    }


    @Test
    void shouldStayOff() {
        // given
        TV tv = new TV("tvModel");

        // when
        tv.pressSleepButton();

        // then
        assertThat(tv).extracting(TV::getCurrentState)
                .extracting(TVState::getMode).isEqualTo(TVMode.OFF);
    }


}
