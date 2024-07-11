package com.patterns.demo.behavioral.command.classic.application.domain.service;

import com.patterns.demo.behavioral.command.classic.application.domain.model.TextFile;
import lombok.NonNull;

// Concrete Command
public record ReadTextFileCommand(@NonNull TextFile textFile) implements TextFileCommand {
    @Override
    public String execute() {
        return textFile.readFile();
    }
}
