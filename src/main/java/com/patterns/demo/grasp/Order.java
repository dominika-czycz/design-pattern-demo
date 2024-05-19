package com.patterns.demo.grasp;


import lombok.Getter;
import lombok.NonNull;

import javax.money.MonetaryAmount;
import java.util.List;
import java.util.UUID;
@Getter
public final class Order {
    private final UUID orderIdentifier;
    private final MonetaryAmount orderPrice;
    private final List<String> orderItems;


    public Order(@NonNull MonetaryAmount orderPrice, @NonNull List<String> orderItems) {
        this.orderIdentifier = UUID.randomUUID();
        this.orderPrice = orderPrice;
        this.orderItems = orderItems;
    }
}
