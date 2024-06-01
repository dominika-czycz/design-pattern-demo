package com.patterns.demo.creational.factorymethod.simplefactory.application.service;


import com.patterns.demo.creational.factorymethod.simplefactory.application.model.Document;
import com.patterns.demo.creational.factorymethod.simplefactory.application.model.DocumentType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DocumentCreatorTest {

    private final DocumentCreator documentCreator = new DocumentCreator();

    @Test
    void shouldReturnTextDocument() {
        //given
        //when
        Document result = documentCreator.createDocument(DocumentType.TEXT);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.TEXT);
    }

    @Test
    void shouldReturnWordDocument() {
        //given
        //when
        Document result = documentCreator.createDocument(DocumentType.WORD);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.WORD);
    }


}