package com.patterns.demo.behavioral.command.functional.application.domain.model;

import lombok.extern.slf4j.Slf4j;

//The Receiver Class
@Slf4j
public record TextFile(String fileName, String content) {

    public String readFile() {
        log.info("Reading text file {}", fileName);
        return content;
    }

    public String save() {
        log.info("Saving text file {}", fileName);
        return fileName;
    }
}
