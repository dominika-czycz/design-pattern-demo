package com.patterns.demo.behavioral.tamplatemethod.service;

import com.patterns.demo.behavioral.tamplatemethod.model.Encryption;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

class RSAEncryption extends Encryption {


    @Override
    protected Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance("RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING");
    }

    @Override
    protected Key getKey() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();
        return keyPair.getPublic();
    }
}
