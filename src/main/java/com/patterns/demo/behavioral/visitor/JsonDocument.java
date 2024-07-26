package com.patterns.demo.behavioral.visitor;


public record JsonDocument(String title, String body) implements Document {
    @Override
    public void accept(Processor processor) {
        processor.process(this);
    }
}
