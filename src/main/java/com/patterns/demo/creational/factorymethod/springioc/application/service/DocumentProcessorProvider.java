package com.patterns.demo.creational.factorymethod.springioc.application.service;

import com.patterns.demo.creational.factorymethod.springioc.application.model.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DocumentProcessorProvider {
    private final Map<DocumentType, DocumentProcessor> processorMap;

    @Autowired
    public DocumentProcessorProvider(List<DocumentProcessor> processors) {
        processorMap = processors.stream()
                .collect(Collectors.toMap(DocumentProcessor::getDocumentType, Function.identity()));

    }

    public DocumentProcessor provideProcessor(DocumentType documentType) {
        return processorMap.get(documentType);
    }
}
