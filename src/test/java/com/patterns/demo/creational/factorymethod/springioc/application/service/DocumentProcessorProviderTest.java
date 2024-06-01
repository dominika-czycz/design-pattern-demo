package com.patterns.demo.creational.factorymethod.springioc.application.service;


import com.patterns.demo.creational.factorymethod.springioc.application.model.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DocumentProcessorProviderTest {
    @Mock
    private WordDocumentProcessor wordDocumentProcessor;
    @Mock
    private TextDocumentProcessor textDocumentProcessor;
    @Mock
    private DocumentProcessorProvider documentProcessorProvider;

    @BeforeEach
    void setUp() {
        when(textDocumentProcessor.getDocumentType()).thenReturn(DocumentType.TEXT);
        when(wordDocumentProcessor.getDocumentType()).thenReturn(DocumentType.WORD);
        documentProcessorProvider = new DocumentProcessorProvider(List.of(wordDocumentProcessor, textDocumentProcessor));
    }

    @Test
    void shouldReturnTextDocumentProcessor() {
        //given
        //when
        DocumentProcessor result = documentProcessorProvider.provideProcessor(DocumentType.TEXT);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.TEXT);
    }

    @Test
    void shouldReturnWordDocumentProcessor() {
        //given
        //when
        DocumentProcessor result = documentProcessorProvider.provideProcessor(DocumentType.WORD);
        //then
        assertThat(result).isNotNull();
        assertThat(result.getDocumentType()).isEqualTo(DocumentType.WORD);
    }

}