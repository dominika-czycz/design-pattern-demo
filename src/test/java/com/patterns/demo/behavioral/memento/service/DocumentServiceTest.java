package com.patterns.demo.behavioral.memento.service;

import com.patterns.demo.behavioral.memento.model.TextDocument;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DocumentServiceTest {

    private final ServiceRelatedToDocumentService serviceRelatedToDocumentService = mock(ServiceRelatedToDocumentService.class);
    private final DocumentService documentService = new DocumentService(serviceRelatedToDocumentService);

    @Test
    void shouldWriteToDocumentWhenSuccess() {
        // give
        TextDocument textDocument = new TextDocument("title");
        when(serviceRelatedToDocumentService.doSomeAction()).thenReturn(true);

        // when
        documentService.writeToDocument(textDocument, "newContent");

        // then
        verify(serviceRelatedToDocumentService).doSomeAction();
        assertThat(textDocument).extracting(TextDocument::getContent).isEqualTo("newContent");
    }

    @Test
    void shouldRollbackDocumentContentWhenFailure() {
        // give
        TextDocument textDocument = new TextDocument("title");
        when(serviceRelatedToDocumentService.doSomeAction()).thenReturn(false);

        // when
        documentService.writeToDocument(textDocument, "newContent");

        // then
        verify(serviceRelatedToDocumentService).doSomeAction();
        assertThat(textDocument).extracting(TextDocument::getContent).isEqualTo("");
    }
}
