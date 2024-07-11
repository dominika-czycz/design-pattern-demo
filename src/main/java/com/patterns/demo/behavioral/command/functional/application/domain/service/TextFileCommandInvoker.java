package com.patterns.demo.behavioral.command.functional.application.domain.service;

import com.patterns.demo.behavioral.command.functional.application.domain.model.TextFile;

public final class TextFileCommandInvoker {
    private TextFileCommandInvoker() {
    }

    public static String invoke(TextFile textFile, TextFileCommand textFileCommand) {
        return textFileCommand.process(textFile);
    }

}
