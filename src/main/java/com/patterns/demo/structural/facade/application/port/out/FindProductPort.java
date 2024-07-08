package com.patterns.demo.structural.facade.application.port.out;

import com.patterns.demo.structural.facade.application.domain.model.Product;

import java.util.Optional;

public interface FindProductPort {
    Optional<Product> findProduct(long id);
}
