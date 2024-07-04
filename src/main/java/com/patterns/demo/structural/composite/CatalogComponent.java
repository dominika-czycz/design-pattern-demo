package com.patterns.demo.structural.composite;

import javax.money.MonetaryAmount;

public interface CatalogComponent {
    String name();

    String content();

    int size();

    MonetaryAmount price();
}
