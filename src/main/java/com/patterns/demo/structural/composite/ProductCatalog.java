package com.patterns.demo.structural.composite;


import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryFunctions;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.List;

public record ProductCatalog(@NonNull String name,
                             @NonNull List<CatalogComponent> componentList) implements CatalogComponent {
    @Override
    public String content() {
        List<String> contentList = componentList.stream().map(CatalogComponent::content).toList();
        return "[" + name + "]" + "\n" + StringUtils.join(contentList, "\n");
    }

    public void add(CatalogComponent component) {
        componentList.add(component);
    }

    public void remove(CatalogComponent component) {
        componentList.remove(component);
    }

    @Override
    public int size() {
        return componentList.stream()
                .reduce(0, (partial, productCatalog) -> partial + productCatalog.size(), Integer::sum);

    }

    @Override
    public MonetaryAmount price() {
        return componentList.stream().map(CatalogComponent::price).reduce(MonetaryFunctions::sum).orElse(Money.zero(Monetary.getCurrency("USD")));
    }

}
