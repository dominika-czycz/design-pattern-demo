package com.patterns.demo.creational.factorymethod.simplefactory.application.model;

public interface Document {
    void open();

    void close();

    void save();

    DocumentType getDocumentType();
}
