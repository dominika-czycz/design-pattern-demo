package com.patterns.demo.grasp;


import lombok.NonNull;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryFunctions;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.List;

public record Customer(@NonNull Long id, @NonNull List<Order> orderList, String defaultsCurrencyCode) {

    public void addOrder(@NonNull MonetaryAmount orderPrice, @NonNull List<String> orderItems) {
        // additional business logic here
        this.orderList.add(new Order(orderPrice, orderItems));
    }

    public MonetaryAmount getTotalCost() {
        return orderList.stream()
                .map(Order::getOrderPrice)
                .reduce(MonetaryFunctions::sum)
                .orElse(Money.zero(Monetary.getCurrency(defaultsCurrencyCode)));
    }

}
