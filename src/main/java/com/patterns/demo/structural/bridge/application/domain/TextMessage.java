package com.patterns.demo.structural.bridge.application.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public final class TextMessage extends Message {
    public TextMessage(@NonNull String body, @NonNull String from, @NonNull String to) {
        super(body, from, to);
        validate();
    }

    @Override
    protected void validate() {
        log.info("Validating text message {}", this);
    }
}
