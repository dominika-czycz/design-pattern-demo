package com.patterns.demo.creational.factorymethod.withenum.application.model;

public interface Document {
    void open();
    void close();
    void save();
    DocumentType getDocumentType();
}
