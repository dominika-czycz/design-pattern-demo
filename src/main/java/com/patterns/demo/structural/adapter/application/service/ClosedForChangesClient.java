package com.patterns.demo.structural.adapter.application.service;

import com.patterns.demo.structural.adapter.application.model.Letter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClosedForChangesClient {
    private final Formatter formatter;

    public void formatDocument(Letter letter) {
        letter.setBody(formatter.format(letter.getBody()));
    }
}
