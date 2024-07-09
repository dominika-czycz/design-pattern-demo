package com.patterns.demo.structural.bridge.application.service;

import com.patterns.demo.structural.bridge.application.domain.EmailMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailMessageService extends MessageService<EmailMessage> {
    private final MessageSender<EmailMessage> messageSender;


    @Override
    protected EmailMessage prepareMessage(String to, String from) {
        return new EmailMessage("Hello", to, from, null);
    }

    @Override
    protected void send(EmailMessage message) {
        messageSender.sendMessage(message);
    }
}
