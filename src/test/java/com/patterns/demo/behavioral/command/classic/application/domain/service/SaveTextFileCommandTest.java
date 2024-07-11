package com.patterns.demo.behavioral.command.classic.application.domain.service;

import com.patterns.demo.behavioral.command.classic.application.domain.model.TextFile;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SaveTextFileCommandTest {

    @Test
    void shouldSaveFile() {
        // given
        TextFile textFile = mock(TextFile.class);
        SaveTextFileCommand saveTextFileCommand = new SaveTextFileCommand(textFile);

        // when
        saveTextFileCommand.execute();

        // then
        verify(textFile).save();
    }
}
