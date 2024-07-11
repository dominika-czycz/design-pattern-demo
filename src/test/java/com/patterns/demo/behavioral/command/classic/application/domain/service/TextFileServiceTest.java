package com.patterns.demo.behavioral.command.classic.application.domain.service;

import com.patterns.demo.behavioral.command.classic.application.domain.model.TextFile;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TextFileServiceTest {
    private static final TextFile TEXT_FILE = new TextFile("fileName", "content");

    private final TextFileCommandInvoker textFileCommandInvoker = mock(TextFileCommandInvoker.class);
    private final TextFileService textFileService = new TextFileService(textFileCommandInvoker);

    @Test
    void shouldReadFile() {
        // given

        when(textFileCommandInvoker.invoke(any(ReadTextFileCommand.class)))
                .thenReturn("content");
        //when
        String result = textFileService.readFile(TEXT_FILE);

        // then
        ArgumentCaptor<ReadTextFileCommand> captor = ArgumentCaptor.forClass(ReadTextFileCommand.class);
        verify(textFileCommandInvoker).invoke(captor.capture());

        ReadTextFileCommand command = captor.getValue();
        assertThat(command).isNotNull();
        assertThat(result).isEqualTo("content");
    }

    @Test
    void shouldSaveFile() {
        // given + when
        textFileService.saveFile(TEXT_FILE);

        // then
        ArgumentCaptor<SaveTextFileCommand> captor = ArgumentCaptor.forClass(SaveTextFileCommand.class);
        verify(textFileCommandInvoker).invoke(captor.capture());

        SaveTextFileCommand command = captor.getValue();
        assertThat(command).isNotNull();
    }
}
