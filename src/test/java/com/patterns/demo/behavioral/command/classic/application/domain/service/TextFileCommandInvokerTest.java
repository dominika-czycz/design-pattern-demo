package com.patterns.demo.behavioral.command.classic.application.domain.service;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TextFileCommandInvokerTest {
    private final TextFileCommandInvoker textFileCommandInvoker = new TextFileCommandInvoker();

    @Test
    void shouldExecuteCommand() {
        // given
        TextFileCommand textFileCommand = mock(TextFileCommand.class);
        // when
        textFileCommandInvoker.invoke(textFileCommand);
        //then
        verify(textFileCommand).execute();
    }
}
