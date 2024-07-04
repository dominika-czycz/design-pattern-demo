package com.patterns.demo.structural.composite;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class ProductCatalogTest {

    @Test
    void shouldReturnProperProductCatalogContent() {
        // given
        CatalogComponent masterCatalog = prepareMasterCatalog();

        //when + then
        assertThat(masterCatalog.content()).isEqualTo("""
                [Master catalog]
                [Book catalog]
                book
                book2
                [Soap catalog]
                soap
                soap2
                [Exclusive soapCatalog]
                exclusive soap
                exclusive soap2""");
    }

    @Test
    void shouldReturnProperProductCatalogSize() {
        // given
        CatalogComponent masterCatalog = prepareMasterCatalog();

        // when + then
        assertThat(masterCatalog.size()).isEqualTo(6);
    }

    @Test
    void shouldReturnProperProductsPrice() {
        // given
        CatalogComponent masterCatalog = prepareMasterCatalog();

        // when + then
        assertThat(masterCatalog.price()).isEqualTo(Money.of(690, "PLN"));
    }

    private static CatalogComponent prepareMasterCatalog() {
        Product book = new Product("book", Money.of(100, "PLN"));
        Product book2 = new Product("book2", Money.of(200, "PLN"));
        ProductCatalog bookCatalog = new ProductCatalog("Book catalog", new ArrayList<>());
        bookCatalog.add(book);
        bookCatalog.add(book2);


        ProductCatalog exclusiveSoapCatalog = new ProductCatalog("Exclusive soapCatalog", new ArrayList<>());
        Product exclusiveSoap = new Product("exclusive soap", Money.of(120, "PLN"));
        Product exclusiveSoap2 = new Product("exclusive soap2", Money.of(240, "PLN"));
        exclusiveSoapCatalog.add(exclusiveSoap);
        exclusiveSoapCatalog.add(exclusiveSoap2);

        Product soap = new Product("soap", Money.of(10, "PLN"));
        Product soap2 = new Product("soap2", Money.of(20, "PLN"));
        ProductCatalog soapCatalog = new ProductCatalog("Soap catalog", new ArrayList<>());
        soapCatalog.add(soap);
        soapCatalog.add(soap2);
        soapCatalog.add(exclusiveSoapCatalog);


        ProductCatalog masterCatalog = new ProductCatalog("Master catalog", new ArrayList<>());
        masterCatalog.add(bookCatalog);
        masterCatalog.add(soapCatalog);
        return masterCatalog;
    }
}
