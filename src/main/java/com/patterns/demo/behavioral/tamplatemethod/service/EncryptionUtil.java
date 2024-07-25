package com.patterns.demo.behavioral.tamplatemethod.service;

import com.patterns.demo.behavioral.tamplatemethod.model.TextFile;

public final class EncryptionUtil {

    private EncryptionUtil() {
    }

    public static byte[] encrypt(TextFile textFile, EncryptionType encryptionType) {
        return textFile.getEncryptedContent(encryptionType.getEncryption());
    }
}
