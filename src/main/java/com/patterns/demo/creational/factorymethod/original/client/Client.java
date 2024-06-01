package com.patterns.demo.creational.factorymethod.original.client;

import com.patterns.demo.creational.factorymethod.original.application.model.Document;
import com.patterns.demo.creational.factorymethod.original.application.service.DocumentCreator;

public class Client {
    private final DocumentCreator documentCreator;

    public Client(DocumentCreator documentCreator) {
        this.documentCreator = documentCreator;
    }

    public Document doSomeOperationsOnDocumentAndReturn() {
        Document document = documentCreator.createDocument();
        document.open();
        document.save();
        document.close();
        return document;
    }
}
