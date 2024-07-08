package com.patterns.demo.structural.facade.application.domain.service;

import com.patterns.demo.structural.facade.application.domain.model.Product;
import com.patterns.demo.structural.facade.application.port.in.PlaceOrderUseCase;
import com.patterns.demo.structural.facade.application.port.out.FindProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceFacade implements PlaceOrderUseCase {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final FindProductPort findProductPort;


    @Override
    public void placeOrder(long productId) {
        Product product = findProductPort.findProduct(productId).orElseThrow(ProductNotFoundException::new);

        if (inventoryService.isAvailable(product) && paymentService.makePayment(product)) {
            shippingService.shipProduct(product);
        }
    }
}
