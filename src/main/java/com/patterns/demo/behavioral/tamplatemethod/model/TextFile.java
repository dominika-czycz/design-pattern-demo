package com.patterns.demo.behavioral.tamplatemethod.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public final class TextFile {
    private final String fileName;
    @Setter
    private String content;

    public byte[] getEncryptedContent(Encryption encryption) {
        return encryption.encrypt(content);
    }

}
