package com.patterns.demo.creational.factorymethod.original.application.service;

import com.patterns.demo.creational.factorymethod.original.application.model.Document;
import com.patterns.demo.creational.factorymethod.original.application.model.TextDocument;

public class TextDocumentCreator implements DocumentCreator {
    @Override
    public Document createDocument() {
        return new TextDocument();
    }
}
