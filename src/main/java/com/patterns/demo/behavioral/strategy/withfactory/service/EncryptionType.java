package com.patterns.demo.behavioral.strategy.withfactory.service;

import com.patterns.demo.behavioral.strategy.withfactory.model.Encryption;

public enum EncryptionType {
    AES {
        @Override
        public Encryption getEncryption() {
            return new AESEncryption();
        }
    }, RSA {
        @Override
        public Encryption getEncryption() {
            return new RSAEncryption();
        }
    };

    public abstract Encryption getEncryption();
}
