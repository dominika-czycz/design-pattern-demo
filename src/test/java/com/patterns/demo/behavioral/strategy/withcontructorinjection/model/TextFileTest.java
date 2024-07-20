package com.patterns.demo.behavioral.strategy.withcontructorinjection.model;


import com.patterns.demo.behavioral.strategy.withconstructorinjection.model.TextFile;
import com.patterns.demo.behavioral.strategy.withconstructorinjection.service.AESEncryption;
import com.patterns.demo.behavioral.strategy.withconstructorinjection.service.RSAEncryption;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TextFileTest {
    @Test
    void shouldBeEncryptedWithAES() {
        //given
        String content = "content";
        AESEncryption aesEncryption = mock(AESEncryption.class);
        byte[] expectedEncryptedContent = "encryptedText".getBytes();
        when(aesEncryption.encrypt(content)).thenReturn(expectedEncryptedContent);
        TextFile fileName = new TextFile("fileName", aesEncryption);
        fileName.setContent(content);
        //when
        byte[] encryptedContent = fileName.getEncryptedContent();
        //then
        verify(aesEncryption).encrypt(content);
        assertThat(encryptedContent).isEqualTo(expectedEncryptedContent);
    }

    @Test
    void shouldBeEncryptedWithRSA() {
        //given
        String content = "content";
        RSAEncryption rsaEncryption = mock(RSAEncryption.class);
        byte[] expectedEncryptedContent = "encryptedText".getBytes();
        when(rsaEncryption.encrypt(content)).thenReturn(expectedEncryptedContent);
        TextFile fileName = new TextFile("fileName", rsaEncryption);
        fileName.setContent(content);
        //when
        byte[] encryptedContent = fileName.getEncryptedContent();
        //then
        verify(rsaEncryption).encrypt(content);
        assertThat(encryptedContent).isEqualTo(expectedEncryptedContent);
    }
}
