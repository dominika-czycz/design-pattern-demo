package com.patterns.demo.structural.bridge.application.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public final class EmailMessage extends Message {
    private final String cc;

    public EmailMessage(@NonNull String body, @NonNull String from, @NonNull String to, String cc) {
        super(body, from, to);
        this.cc = cc;
        validate();
    }


    @Override
    protected void validate() {
        log.info("Validating email message {}", this);
    }
}
