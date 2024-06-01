package com.patterns.demo.creational.factorymethod.simplefactory.client;


import com.patterns.demo.creational.factorymethod.simplefactory.application.model.Document;
import com.patterns.demo.creational.factorymethod.simplefactory.application.model.DocumentType;
import com.patterns.demo.creational.factorymethod.simplefactory.application.service.DocumentCreator;

public class Client {
    private final DocumentCreator documentCreator;

    public Client(DocumentCreator documentCreator) {
        this.documentCreator = documentCreator;
    }

    public Document doSomeOperationsOnDocumentAndReturn(DocumentType documentType) {
        Document document = documentCreator.createDocument(documentType);
        document.open();
        document.save();
        document.close();
        return document;
    }
}
