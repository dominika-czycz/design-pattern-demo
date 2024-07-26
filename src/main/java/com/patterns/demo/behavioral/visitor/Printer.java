package com.patterns.demo.behavioral.visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Printer implements Processor {
    @Override
    public void process(TextDocument textDocument) {
        log.info("Printing text document {}", textDocument.content());
    }

    @Override
    public void process(JsonDocument jsonDocument) {
        log.info("Printing json document {}", jsonDocument.body());
    }
}
