package com.patterns.demo.creational.factorymethod.withenum.client;

import com.patterns.demo.creational.factorymethod.withenum.application.model.Document;
import com.patterns.demo.creational.factorymethod.withenum.application.model.DocumentType;

import java.util.List;

public class Client {

    public Document doSomeOperationsOnDocumentAndReturn(DocumentType documentType) {
        Document document = documentType.createDocument();
        document.open();
        document.save();
        document.close();
        return document;
    }

    public List<Document> createDocuments(List<DocumentType> documentTypes) {
        return documentTypes.stream().map(DocumentType::createDocument).toList();
    }
}
