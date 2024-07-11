package com.patterns.demo.behavioral.command.classic.application.domain.service;

/*
Invoker is a thin layer of abstraction that decouples the command from their consumer.
An invoker knows how to execute a given command but does not know its implementation.
In some cases, the invoker also stores and queues commands. This is useful  when we need
to add some further control to the commands' execution process. For example, when  implementing
macro recording or undo and redo functionality.
*/
public class TextFileCommandInvoker {
    public String invoke(TextFileCommand textFileCommand) {
        return textFileCommand.execute();
    }
}
