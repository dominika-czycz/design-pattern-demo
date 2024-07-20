package com.patterns.demo.behavioral.strategy.withfactory.service;

import com.patterns.demo.behavioral.strategy.withfactory.model.TextFile;

public final class EncryptionUtil {

    private EncryptionUtil() {
    }

    public static byte[] encrypt(TextFile textFile, EncryptionType encryptionType) {
        return textFile.getEncryptedContent(encryptionType.getEncryption());
    }
}
