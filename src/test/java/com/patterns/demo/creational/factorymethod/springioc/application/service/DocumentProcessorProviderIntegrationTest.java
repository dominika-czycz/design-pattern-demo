package com.patterns.demo.creational.factorymethod.springioc.application.service;

import com.patterns.demo.creational.factorymethod.springioc.application.model.DocumentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DocumentProcessorProviderIntegrationTest {
    @Autowired
    private DocumentProcessorProvider documentProcessorProvider;

    @Test
    void shouldReturnTextDocument() {
        //given
        //when
        DocumentProcessor result = documentProcessorProvider.provideProcessor(DocumentType.TEXT);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.TEXT);
    }
}