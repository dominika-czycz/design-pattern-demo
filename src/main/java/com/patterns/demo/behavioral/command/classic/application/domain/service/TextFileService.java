package com.patterns.demo.behavioral.command.classic.application.domain.service;

import com.patterns.demo.behavioral.command.classic.application.domain.model.TextFile;
import lombok.RequiredArgsConstructor;

//Client
@RequiredArgsConstructor
public class TextFileService {
    private final TextFileCommandInvoker textFileCommandInvoker;

    public String readFile(TextFile textFile) {
        return textFileCommandInvoker.invoke(new ReadTextFileCommand(textFile));
    }

    public void saveFile(TextFile textFile) {
        textFileCommandInvoker.invoke(new SaveTextFileCommand(textFile));
    }

}
