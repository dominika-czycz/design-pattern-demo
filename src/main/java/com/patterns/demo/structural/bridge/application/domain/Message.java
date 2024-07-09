package com.patterns.demo.structural.bridge.application.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Message {
    @NonNull
    private final String body;
    @NonNull
    private final String from;
    @NonNull
    private final String to;

    protected abstract void validate();

}
