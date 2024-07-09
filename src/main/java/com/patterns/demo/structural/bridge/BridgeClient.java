package com.patterns.demo.structural.bridge;

import com.patterns.demo.structural.bridge.application.service.MessageService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BridgeClient {
    private final MessageService<?> messageService;

    public void sendMessage(String to, String from) {
        messageService.sendDefaultMessage(to, from);
    }

}
