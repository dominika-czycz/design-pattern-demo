package com.patterns.demo.creational.factorymethod.original.client;

import com.patterns.demo.creational.factorymethod.original.application.model.Document;
import com.patterns.demo.creational.factorymethod.original.application.model.DocumentType;
import com.patterns.demo.creational.factorymethod.original.application.service.TextDocumentCreator;
import com.patterns.demo.creational.factorymethod.original.application.service.WordDocumentCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientIntegrationTest {
    @Test
    void shouldReturnTextDocument() {
        //given
        Client client = new Client(new TextDocumentCreator());
        //when
        Document result = client.doSomeOperationsOnDocumentAndReturn();
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.TEXT);
    }

    @Test
    void shouldReturnWordDocument() {
        //given
        Client client = new Client(new WordDocumentCreator());
        //when
        Document result = client.doSomeOperationsOnDocumentAndReturn();
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.WORD);
    }
}