package com.patterns.demo.structural.bridge.application.service;

import com.patterns.demo.structural.bridge.application.domain.Message;

public abstract class MessageService<MESSAGE extends Message> {

    public void sendDefaultMessage(String to, String from) {
        send(prepareMessage(to, from));
    }

    protected abstract MESSAGE prepareMessage(String to, String from);

    protected abstract void send(MESSAGE message);
}
