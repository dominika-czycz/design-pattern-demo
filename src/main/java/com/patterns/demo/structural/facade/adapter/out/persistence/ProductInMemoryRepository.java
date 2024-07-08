package com.patterns.demo.structural.facade.adapter.out.persistence;

import com.patterns.demo.structural.facade.application.domain.model.Product;
import com.patterns.demo.structural.facade.application.port.out.FindProductPort;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Repository
public class ProductInMemoryRepository implements FindProductPort {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();

    public ProductInMemoryRepository() {
        products.putAll(LongStream.range(0, 20).mapToObj(ProductInMemoryRepository::createProduct)
                .collect(Collectors.toMap(Product::productId, Function.identity())));
    }

    private static Product createProduct(long id) {
        return new Product(id, "name" + id);
    }

    @Override
    public Optional<Product> findProduct(long id) {
        return Optional.ofNullable(products.get(id));
    }
}
