package com.patterns.demo.behavioral.command.functional.application.domain.service;

import com.patterns.demo.behavioral.command.functional.application.domain.model.TextFile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class TextFileServiceTest {

    private final TextFileService textFileService = new TextFileService();

    @Test
    void shouldReadFile() {
        // given
        TextFile textFile = mock(TextFile.class);
        when(textFile.readFile()).thenReturn("content");

        // when
        String result = textFileService.readFile(textFile);

        // then
        verify(textFile).readFile();
        assertThat(result).isEqualTo("content");

    }

    @Test
    void shouldSaveFile() {
        // given
        TextFile textFile = mock(TextFile.class);

        //when
        textFileService.saveFile(textFile);

        // then
        verify(textFile).save();

    }

}
