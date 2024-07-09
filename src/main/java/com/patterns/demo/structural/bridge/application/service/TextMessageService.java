package com.patterns.demo.structural.bridge.application.service;

import com.patterns.demo.structural.bridge.application.domain.TextMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TextMessageService extends MessageService<TextMessage> {
    private final MessageSender<TextMessage> messageSender;

    @Override
    protected TextMessage prepareMessage(String to, String from) {
        return new TextMessage("Hello", to, from);
    }

    @Override
    public void send(TextMessage message) {
        messageSender.sendMessage(message);
    }
}
