package com.patterns.demo.behavioral.chainofresponsibility.application;

import com.patterns.demo.behavioral.chainofresponsibility.application.model.Car;
import com.patterns.demo.behavioral.chainofresponsibility.application.model.ElementsState;
import com.patterns.demo.behavioral.chainofresponsibility.application.model.UnrepairedCarException;
import com.patterns.demo.behavioral.chainofresponsibility.application.service.CarService;
import com.patterns.demo.behavioral.chainofresponsibility.application.service.ElectronicCarService;
import com.patterns.demo.behavioral.chainofresponsibility.application.service.MechanicCarService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ReceptionistIntegrationTest {

    private static Car createBrokenCar() {
        return new Car("DW6786F", "Honda Civic", ElementsState.NOT_WORKING, ElementsState.NOT_WORKING);
    }

    @Test
    void shouldArrangeSuccessfulCarRepairWhenFirstMechanic() {
        // given
        Car car = createBrokenCar();
        CarService firstSpecialistService = new MechanicCarService();
        CarService secondSpecialistService = new ElectronicCarService();
        firstSpecialistService.setNext(secondSpecialistService);
        Receptionist receptionist = new Receptionist(firstSpecialistService);

        // when
        receptionist.arrangeCarRepair(car);

        // then
        assertThat(car).extracting(Car::isWorking).isEqualTo(true);
    }

    @Test
    void shouldArrangeSuccessfulCarRepairWhenFirstElectronic() {
        // given
        Car car = createBrokenCar();
        CarService firstSpecialist = new ElectronicCarService();
        CarService secondSpecialist = new MechanicCarService();
        firstSpecialist.setNext(secondSpecialist);
        Receptionist receptionist = new Receptionist(firstSpecialist);

        // when
        receptionist.arrangeCarRepair(car);

        // then
        assertThat(car).extracting(Car::isWorking).isEqualTo(true);
    }

    @Test
    void shouldThrowUnrepairedCarException() {
        // given
        Car car = createBrokenCar();
        CarService firstSpecialistService = new MechanicCarService();
        Receptionist receptionist = new Receptionist(firstSpecialistService);

        // when + then
        assertThatExceptionOfType(UnrepairedCarException.class).isThrownBy(() -> receptionist.arrangeCarRepair(car));
    }
}
