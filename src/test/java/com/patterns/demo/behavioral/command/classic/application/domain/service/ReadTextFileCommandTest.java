package com.patterns.demo.behavioral.command.classic.application.domain.service;

import com.patterns.demo.behavioral.command.classic.application.domain.model.TextFile;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ReadTextFileCommandTest {
    @Test
    void shouldReadFile() {
        // given
        TextFile textFile = mock(TextFile.class);
        ReadTextFileCommand readTextFileCommand = new ReadTextFileCommand(textFile);

        // when
        readTextFileCommand.execute();

        // then
        verify(textFile).readFile();
    }
}
