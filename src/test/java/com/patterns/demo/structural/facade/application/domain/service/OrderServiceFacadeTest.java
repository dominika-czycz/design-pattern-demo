package com.patterns.demo.structural.facade.application.domain.service;


import com.patterns.demo.structural.facade.application.domain.model.Product;
import com.patterns.demo.structural.facade.application.port.out.FindProductPort;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OrderServiceFacadeTest {
    private final InventoryService inventoryService = mock(InventoryService.class);
    private final PaymentService paymentService = mock(PaymentService.class);
    private final ShippingService shippingService = mock(ShippingService.class);
    private final FindProductPort findProductPort = mock(FindProductPort.class);
    private final OrderServiceFacade orderServiceFacade = new OrderServiceFacade(inventoryService, paymentService, shippingService, findProductPort);

    @Test
    void shouldShipProduct() {
        // given
        Product product = new Product(1L, "ProductName");
        when(findProductPort.findProduct(1L)).thenReturn(Optional.of(product));
        when(inventoryService.isAvailable(product)).thenReturn(true);
        when(paymentService.makePayment(product)).thenReturn(true);

        // when
        orderServiceFacade.placeOrder(1L);

        // then
        verify(findProductPort).findProduct(1L);
        verify(inventoryService).isAvailable(product);
        verify(paymentService).makePayment(product);
        verify(shippingService).shipProduct(product);
    }
}
