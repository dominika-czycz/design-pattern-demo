package com.patterns.demo.structural.bridge.application.service;

import com.patterns.demo.structural.bridge.application.domain.Message;

public interface MessageSender<MESSAGE extends Message> {
    void sendMessage(MESSAGE message);
}
