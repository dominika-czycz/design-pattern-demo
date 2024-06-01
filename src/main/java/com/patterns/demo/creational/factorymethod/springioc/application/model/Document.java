package com.patterns.demo.creational.factorymethod.springioc.application.model;

public interface Document {
    void open();

    void close();

    void save();

    String metaData();

    String name();

    DocumentType getDocumentType();
}
