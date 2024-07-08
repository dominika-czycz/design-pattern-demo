package com.patterns.demo.structural.facade.adapter.in.web;

import com.patterns.demo.structural.facade.application.port.in.PlaceOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class PlaceOrderController {
    private final PlaceOrderUseCase placeOrderUseCase;

    @PostMapping(path = "/order/{productId}")
    void placeOrder(@PathVariable Long productId) {
        placeOrderUseCase.placeOrder(productId);
    }
}
