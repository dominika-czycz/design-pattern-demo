package com.patterns.demo.creational.factorymethod.simplefactory.client;


import com.patterns.demo.creational.factorymethod.simplefactory.application.model.Document;
import com.patterns.demo.creational.factorymethod.simplefactory.application.model.DocumentType;
import com.patterns.demo.creational.factorymethod.simplefactory.application.model.TextDocument;
import com.patterns.demo.creational.factorymethod.simplefactory.application.model.WordDocument;
import com.patterns.demo.creational.factorymethod.simplefactory.application.service.DocumentCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


class ClientTest {

    private Client client;
    private DocumentCreator documentCreator;

    @BeforeEach
    void setUp() {
        documentCreator = Mockito.mock(DocumentCreator.class);
        client = new Client(documentCreator);
    }

    @Test
    void shouldReturnTextDocument() {
        //given
        when(documentCreator.createDocument(DocumentType.TEXT)).thenReturn(new TextDocument());
        //when
        Document result = client.doSomeOperationsOnDocumentAndReturn(DocumentType.TEXT);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.TEXT);
    }

    @Test
    void shouldReturnWordDocument() {
        //given
        when(documentCreator.createDocument(DocumentType.WORD)).thenReturn(new WordDocument());
        //when
        Document result = client.doSomeOperationsOnDocumentAndReturn(DocumentType.WORD);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.WORD);
    }

}