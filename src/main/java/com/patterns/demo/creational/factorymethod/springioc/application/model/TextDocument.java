package com.patterns.demo.creational.factorymethod.springioc.application.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record TextDocument(String name, String metaData, String dataSpecificForText) implements Document {

    @Override
    public void open() {
        //some business logic here
        log.info("{} {} document has been opened", this.name, getDocumentType());
    }

    @Override
    public void close() {
        //some business logic here
        log.info("{} {} document has been closed", this.name, getDocumentType());
    }

    @Override
    public void save() {
        //some business logic here
        log.info("{} {} document has been saved", this.name, getDocumentType());
    }

    @Override
    public DocumentType getDocumentType() {
        return DocumentType.TEXT;
    }
}
