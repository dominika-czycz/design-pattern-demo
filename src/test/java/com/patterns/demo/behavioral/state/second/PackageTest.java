package com.patterns.demo.behavioral.state.second;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PackageTest {

    private static final String PACKAGE_ID = "packageId";

    @Test
    void shouldBeInOrderedStateInitially() {
        // given
        Package aPackage = new Package(PACKAGE_ID);

        // when + then
        assertIsInState(aPackage, PackageStatus.ORDERED);
    }

    @Test
    void shouldNotChangeStateToPreviousWhenInOrderedState() {
        // given
        Package aPackage = new Package(PACKAGE_ID);

        // when
        aPackage.moveToPreviousState();

        // then
        assertIsInState(aPackage, PackageStatus.ORDERED);
    }

    @Test
    void shouldChangeStateToDelivered() {
        // given
        Package aPackage = new Package(PACKAGE_ID);

        // when
        aPackage.moveToNextState();

        // then
        assertIsInState(aPackage, PackageStatus.DELIVERED);
    }

    @Test
    void shouldRollbackToOrdered() {
        // given
        Package aPackage = new Package(PACKAGE_ID);
        aPackage.moveToNextState();
        assertIsInState(aPackage, PackageStatus.DELIVERED);

        // when
        aPackage.moveToPreviousState();

        // then
        assertIsInState(aPackage, PackageStatus.ORDERED);
    }

    @Test
    void shouldChangeStateFromDeliveredToReceived() {
        // given
        Package aPackage = new Package(PACKAGE_ID);
        aPackage.moveToNextState();
        assertIsInState(aPackage, PackageStatus.DELIVERED);

        // when
        aPackage.moveToNextState();

        // then
        assertIsInState(aPackage, PackageStatus.RECEIVED);
    }

    @Test
    void shouldNotChangeStateToNextWhenInReceivedState() {
        // given
        Package aPackage = new Package(PACKAGE_ID);
        aPackage.moveToNextState();
        aPackage.moveToNextState();
        assertIsInState(aPackage, PackageStatus.RECEIVED);

        // when
        aPackage.moveToNextState();
        // then
        assertIsInState(aPackage, PackageStatus.RECEIVED);
    }

    private static void assertIsInState(Package aPackage, PackageStatus delivered) {
        assertThat(aPackage).extracting(Package::getPackageState)
                .isEqualTo(delivered);
    }
}
