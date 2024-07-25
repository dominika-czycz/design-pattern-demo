package com.patterns.demo.behavioral.tamplatemethod.service;


import com.patterns.demo.behavioral.tamplatemethod.model.TextFile;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

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
        assertThat(new String(encrypted, StandardCharsets.UTF_8)).isNotEqualTo(content);
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
        assertThat(new String(encrypted, StandardCharsets.UTF_8)).isNotEqualTo(content);
    }
}
