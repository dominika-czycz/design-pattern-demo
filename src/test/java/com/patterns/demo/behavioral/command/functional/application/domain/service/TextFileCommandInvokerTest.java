package com.patterns.demo.behavioral.command.functional.application.domain.service;

import com.patterns.demo.behavioral.command.functional.application.domain.model.TextFile;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TextFileCommandInvokerTest {

    @Test
    void shouldInvokeFileOperation() {
        // given
        TextFile textFile = mock(TextFile.class);

        // when
        TextFileCommandInvoker.invoke(textFile, TextFile::readFile);

        // then

        verify(textFile).readFile();
    }
}
