package com.patterns.demo.creational.factorymethod.withenum.client;


import com.patterns.demo.creational.factorymethod.withenum.application.model.Document;
import com.patterns.demo.creational.factorymethod.withenum.application.model.DocumentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {

    private final Client client = new Client();

    @Test
    void shouldReturnTextDocument() {
        //given
        //when
        Document result = client.doSomeOperationsOnDocumentAndReturn(DocumentType.TEXT);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.TEXT);
    }

    @Test
    void shouldReturnWordDocument() {
        //given
        //when
        Document result = client.doSomeOperationsOnDocumentAndReturn(DocumentType.WORD);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.WORD);
    }

    @Test
    void shouldReturnsDocuments() {
        //given
        //when
        List<Document> results = client.createDocuments(List.of(DocumentType.TEXT, DocumentType.WORD));
        //then
        assertThat(results).isNotEmpty().hasSize(2)
                .extracting(Document::getDocumentType)
                .containsExactlyInAnyOrder(DocumentType.TEXT, DocumentType.WORD);
    }
}