package com.patterns.demo.creational.factorymethod.springioc.application.service;

import com.patterns.demo.creational.factorymethod.springioc.application.model.Document;
import com.patterns.demo.creational.factorymethod.springioc.application.model.DocumentType;
import com.patterns.demo.creational.factorymethod.springioc.application.model.WordDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class WordDocumentProcessor implements DocumentProcessor {

    @Override
    public void process(Document document) {
        //  some specific word document logic here
        if (document instanceof WordDocument wordDocument) {
            log.info("Processing word document with specific data {}", wordDocument.dataSpecificForWord());
            wordDocument.open();
            wordDocument.save();
            wordDocument.close();
        } else {
            throw new IllegalArgumentException("Document is not of type WordDocument");
        }
    }

    @Override
    public DocumentType getDocumentType() {
        return DocumentType.WORD;
    }

}
