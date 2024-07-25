package com.patterns.demo.behavioral.tamplatemethod.model;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public abstract class Encryption {
    public byte[] encrypt(String content) {
        try {
            Key key = getKey();

            byte[] plaintTextByteArray = content.getBytes(StandardCharsets.UTF_8);

            Cipher cipher = getCipher();
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(plaintTextByteArray);
        } catch (Exception ex) {
            throw new FailedEncryptionException();
        }
    }

    protected abstract Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException;

    protected abstract Key getKey() throws NoSuchAlgorithmException;
}
