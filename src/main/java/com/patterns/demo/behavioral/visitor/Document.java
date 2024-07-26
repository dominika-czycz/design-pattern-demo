package com.patterns.demo.behavioral.visitor;

public interface Document {
    void accept(Processor processor);
}
