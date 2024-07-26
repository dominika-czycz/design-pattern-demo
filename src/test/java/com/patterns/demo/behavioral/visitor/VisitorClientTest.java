package com.patterns.demo.behavioral.visitor;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class VisitorClientTest {
    private final Processor processor = mock(Processor.class);
    private final VisitorClient visitorClient = new VisitorClient(processor);

    @Test
    void shouldProcessTextDocument() {
        // given
        TextDocument textDocument = new TextDocument("title", "content");

        // when
        visitorClient.processDocument(textDocument);

        // then
        then(processor).should().process(textDocument);
    }
}
