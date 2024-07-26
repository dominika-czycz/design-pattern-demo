package com.patterns.demo.behavioral.visitor;

public interface Processor {
    void process(TextDocument textDocument);

    void process(JsonDocument jsonDocument);
}
