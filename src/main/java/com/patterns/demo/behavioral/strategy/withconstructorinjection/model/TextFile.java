package com.patterns.demo.behavioral.strategy.withconstructorinjection.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public final class TextFile {

    private final String fileName;
    private final Encryption encryption;

    @Setter
    private String content;

    public byte[] getEncryptedContent() {
        return encryption.encrypt(this.content);
    }

}
