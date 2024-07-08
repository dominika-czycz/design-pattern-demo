package com.patterns.demo.structural.facade.application.domain.service;

import com.patterns.demo.structural.facade.application.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class PaymentService {
    public boolean makePayment(Product product) {
        log.info("Making payment for product {}", product);
        /* Connect with payment gateway for payment */
        return true;
    }
}
