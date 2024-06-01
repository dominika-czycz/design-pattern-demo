package com.patterns.demo.creational.factorymethod.springioc.client;


import com.patterns.demo.creational.factorymethod.springioc.application.model.Document;
import com.patterns.demo.creational.factorymethod.springioc.application.model.DocumentType;
import com.patterns.demo.creational.factorymethod.springioc.application.model.TextDocument;
import com.patterns.demo.creational.factorymethod.springioc.application.service.DocumentProcessor;
import com.patterns.demo.creational.factorymethod.springioc.application.service.DocumentProcessorProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClientTest {

    private final DocumentProcessorProvider documentProcessorProvider = Mockito.mock(DocumentProcessorProvider.class);
    private final DocumentProcessor documentProcessor = Mockito.mock(DocumentProcessor.class);
    private final Client client = new Client(documentProcessorProvider);


    @Test
    void shouldProcessDocument() {
        //given
        Document document = new TextDocument("name", "metadata", "specific");
        when(documentProcessor.getDocumentType()).thenReturn(DocumentType.TEXT);
        when(documentProcessorProvider.provideProcessor(DocumentType.TEXT)).thenReturn(documentProcessor);
        //when
        client.doSomeOperationsOnDocument(document);
        //then
        verify(documentProcessor).process(document);
    }

}