package com.patterns.demo.structural.facade.application.domain.service;

import com.patterns.demo.structural.facade.application.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class InventoryService {
    public boolean isAvailable(Product product) {
        /* Check database for product availability */
        log.info("Checking if product {} is Available", product);
        return true;
    }
}
