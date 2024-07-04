package com.patterns.demo.structural.composite;

import lombok.NonNull;
import org.javamoney.moneta.Money;


public record Product(@NonNull String name, @NonNull Money price) implements CatalogComponent {
    @Override
    public String content() {
        return this.name;
    }

    @Override
    public int size() {
        return 1;
    }
}
