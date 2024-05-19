package com.patterns.demo.grasp;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

    @Test
    void shouldReturnTotalCost() {
        //given
        Customer customer = new Customer(1L, new ArrayList<>(), "PLN");
        customer.addOrder(Money.of(10, "PLN"), List.of("item1", "item2"));
        customer.addOrder(Money.of(20, "PLN"), List.of("item3", "item4"));
        //when
        MonetaryAmount totalCost = customer.getTotalCost();
        //then
        assertThat(totalCost).isEqualTo(Money.of(30, "PLN"));
    }
}