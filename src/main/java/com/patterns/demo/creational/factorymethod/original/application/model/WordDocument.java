package com.patterns.demo.creational.factorymethod.original.application.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WordDocument implements Document {
    @Override
    public void open() {
        //some business logic here
        log.info("{} document has been opened", getDocumentType());
    }

    @Override
    public void close() {
        //some business logic here
        log.info("{} Text document has been closed", getDocumentType());
    }

    @Override
    public void save() {
        //some business logic here
        log.info("{} Text document has been saved", getDocumentType());
    }

    @Override
    public DocumentType getDocumentType() {
        return DocumentType.WORD;
    }


}
