package com.patterns.demo.creational.factorymethod.springioc.client;


import com.patterns.demo.creational.factorymethod.springioc.application.model.Document;
import com.patterns.demo.creational.factorymethod.springioc.application.service.DocumentProcessorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Client {
    private final DocumentProcessorProvider documentProcessorProvider;

    public void doSomeOperationsOnDocument(Document document) {
        documentProcessorProvider.provideProcessor(document.getDocumentType()).process(document);
    }
}
