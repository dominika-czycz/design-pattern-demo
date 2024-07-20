package com.patterns.demo.behavioral.strategy.withfactory.service;

import com.patterns.demo.behavioral.strategy.withfactory.model.TextFile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EncryptionUtilTest {
    @Test
    void shouldBeEncryptedWithAES() {
        //given
        String content = "content";
        TextFile textFile = new TextFile("textFile");
        textFile.setContent(content);
        //when
        byte[] encrypted = EncryptionUtil.encrypt(textFile, EncryptionType.AES);
        //then
        assertThat(encrypted).isNotEmpty();
    }

    @Test
    void shouldBeEncryptedWithRSA() {
        //given
        String content = "content";
        TextFile textFile = new TextFile("textFile");
        textFile.setContent(content);
        //when
        byte[] encrypted = EncryptionUtil.encrypt(textFile, EncryptionType.RSA);
        //then
        assertThat(encrypted).isNotEmpty();
    }
}
