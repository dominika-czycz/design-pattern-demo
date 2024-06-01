package com.patterns.demo.creational.factorymethod.original.application.service;

import com.patterns.demo.creational.factorymethod.original.application.model.Document;
import com.patterns.demo.creational.factorymethod.original.application.model.WordDocument;

public class WordDocumentCreator implements DocumentCreator {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
