package com.patterns.demo.behavioral.visitor;


public record TextDocument(String title, String content) implements Document {
    @Override
    public void accept(Processor processor) {
        processor.process(this);
    }
}
