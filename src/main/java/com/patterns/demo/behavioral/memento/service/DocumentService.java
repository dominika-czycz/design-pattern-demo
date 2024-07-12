package com.patterns.demo.behavioral.memento.service;

import com.patterns.demo.behavioral.memento.model.TextDocument;
import com.patterns.demo.behavioral.memento.model.TextDocumentMemento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final ServiceRelatedToDocumentService serviceRelatedToDocumentService;

    public TextDocument createDocument(String title) {
        return new TextDocument(title);
    }

    public void writeToDocument(TextDocument document, String text) {
        TextDocumentMemento memento = document.createMemento();
        document.write(text);
        boolean success = serviceRelatedToDocumentService.doSomeAction();
        if (!success) {
            document.restoreFromMemento(memento);
        }
    }
}
