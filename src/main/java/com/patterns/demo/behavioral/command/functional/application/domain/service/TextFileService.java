package com.patterns.demo.behavioral.command.functional.application.domain.service;


import com.patterns.demo.behavioral.command.functional.application.domain.model.TextFile;

//Client
public class TextFileService {

    public String readFile(TextFile textFile) {
        return TextFileCommandInvoker.invoke(textFile, TextFile::readFile);
    }

    public void saveFile(TextFile textFile) {
        TextFileCommandInvoker.invoke(textFile, TextFile::save);
    }

}
