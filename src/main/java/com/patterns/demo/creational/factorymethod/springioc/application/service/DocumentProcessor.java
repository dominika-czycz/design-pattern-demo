package com.patterns.demo.creational.factorymethod.springioc.application.service;

import com.patterns.demo.creational.factorymethod.springioc.application.model.Document;
import com.patterns.demo.creational.factorymethod.springioc.application.model.DocumentType;

public interface DocumentProcessor {
    void process(Document document);

    DocumentType getDocumentType();
}
