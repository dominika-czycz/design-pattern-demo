package com.patterns.demo.creational.factorymethod.original.application.model;

public interface Document {
    void open();

    void close();

    void save();

    DocumentType getDocumentType();
}
