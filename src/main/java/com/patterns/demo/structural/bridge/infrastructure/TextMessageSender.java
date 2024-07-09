package com.patterns.demo.structural.bridge.infrastructure;

import com.patterns.demo.structural.bridge.application.domain.TextMessage;
import com.patterns.demo.structural.bridge.application.service.MessageSender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextMessageSender implements MessageSender<TextMessage> {
    @Override
    public void sendMessage(TextMessage message) {
        log.info("Sending TextMessage: {}", message);
    }
}
