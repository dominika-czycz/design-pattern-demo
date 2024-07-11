package com.patterns.demo.behavioral.command.functional.application.domain.service;

import com.patterns.demo.behavioral.command.functional.application.domain.model.TextFile;

@FunctionalInterface
public interface TextFileCommand {
    String process(TextFile textFile);
}
