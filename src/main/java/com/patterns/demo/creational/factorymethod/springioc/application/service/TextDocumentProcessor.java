package com.patterns.demo.creational.factorymethod.springioc.application.service;

import com.patterns.demo.creational.factorymethod.springioc.application.model.Document;
import com.patterns.demo.creational.factorymethod.springioc.application.model.DocumentType;
import com.patterns.demo.creational.factorymethod.springioc.application.model.TextDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class TextDocumentProcessor implements DocumentProcessor {

    @Override
    public void process(Document document) {
        //  some specific text document logic here
        if (document instanceof TextDocument textDocument) {
            log.info("Processing text document with specific data {}", textDocument.dataSpecificForText());
            textDocument.open();
            textDocument.save();
            textDocument.close();
        } else {
            throw new IllegalArgumentException("Document is not of type TextDocument");
        }
    }

    @Override
    public DocumentType getDocumentType() {
        return DocumentType.TEXT;
    }

}
