package com.patterns.demo.structural.facade.application.domain.service;

import com.patterns.demo.structural.facade.application.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class ShippingService {
    public void shipProduct(Product product) {
        log.info("Shipping product {}", product);
        /* Connect with external shipment service to ship product */
    }
}
