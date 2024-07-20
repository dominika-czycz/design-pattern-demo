package com.patterns.demo.behavioral.strategy.withconstructorinjection.service;

import com.patterns.demo.behavioral.strategy.withconstructorinjection.model.Encryption;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;

public class RSAEncryption implements Encryption {
    @Override
    public byte[] encrypt(String text) {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair keyPair = generator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            byte[] plaintTextByteArray = text.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(plaintTextByteArray);
        } catch (Exception ex) {
            throw new FailedEncryptionException();
        }

    }
}
