package com.patterns.demo.behavioral.visitor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VisitorClient {
    private final Processor processor;

    public void processDocument(Document document) {
        document.accept(processor);
    }

}
