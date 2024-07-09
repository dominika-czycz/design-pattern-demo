package com.patterns.demo.structural.bridge.infrastructure;

import com.patterns.demo.structural.bridge.application.domain.EmailMessage;
import com.patterns.demo.structural.bridge.application.service.MessageSender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailMessageSender implements MessageSender<EmailMessage> {
    @Override
    public void sendMessage(EmailMessage message) {
        log.info("Sending email message: {}", message);
    }
}
