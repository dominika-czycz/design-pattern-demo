package com.patterns.demo.behavioral.strategy.withcontructorinjection.model;


import com.patterns.demo.behavioral.strategy.withconstructorinjection.model.TextFile;
import com.patterns.demo.behavioral.strategy.withconstructorinjection.service.AESEncryption;
import com.patterns.demo.behavioral.strategy.withconstructorinjection.service.RSAEncryption;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class TextFileTest {
    @Test
    void shouldBeEncryptedWithAES() {
        //given
        String content = "content";
        AESEncryption aesEncryption = mock(AESEncryption.class);
        byte[] expectedEncryptedContent = "encryptedText".getBytes();
        given(aesEncryption.encrypt(content)).willReturn(expectedEncryptedContent);
        TextFile fileName = new TextFile("fileName", aesEncryption);
        fileName.setContent(content);

        //when
        byte[] encryptedContent = fileName.getEncryptedContent();

        //then
        then(aesEncryption).should().encrypt(content);
        assertThat(encryptedContent).isEqualTo(expectedEncryptedContent);
    }

    @Test
    void shouldBeEncryptedWithRSA() {
        //given
        String content = "content";
        RSAEncryption rsaEncryption = mock(RSAEncryption.class);
        byte[] expectedEncryptedContent = "encryptedText".getBytes();
        given(rsaEncryption.encrypt(content)).willReturn(expectedEncryptedContent);
        TextFile fileName = new TextFile("fileName", rsaEncryption);
        fileName.setContent(content);

        //when
        byte[] encryptedContent = fileName.getEncryptedContent();

        //then
        then(rsaEncryption).should().encrypt(content);
        assertThat(encryptedContent).isEqualTo(expectedEncryptedContent);
    }
}
