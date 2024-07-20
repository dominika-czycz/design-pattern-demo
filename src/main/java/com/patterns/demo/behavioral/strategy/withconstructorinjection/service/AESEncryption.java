package com.patterns.demo.behavioral.strategy.withconstructorinjection.service;

import com.patterns.demo.behavioral.strategy.withconstructorinjection.model.Encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class AESEncryption implements Encryption {

    @Override
    public byte[] encrypt(String content) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] plaintTextByteArray = content.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(plaintTextByteArray);
        } catch (Exception ex) {
            throw new FailedEncryptionException();
        }
    }
}

