package com.patterns.demo.creational.factorymethod.simplefactory.application.service;

import com.patterns.demo.creational.factorymethod.simplefactory.application.model.Document;
import com.patterns.demo.creational.factorymethod.simplefactory.application.model.DocumentType;
import com.patterns.demo.creational.factorymethod.simplefactory.application.model.TextDocument;
import com.patterns.demo.creational.factorymethod.simplefactory.application.model.WordDocument;

public class DocumentCreator {
    public Document createDocument(DocumentType documentType) {
        return switch (documentType) {
            case TEXT -> new TextDocument();
            case WORD -> new WordDocument();
        };
    }
}
