package com.patterns.demo.structural.adapter.application.service;

import com.patterns.demo.structural.adapter.external.CsvFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdapterFormatter implements Formatter {
    private final CsvFormatter csvFormatter;

    @Override
    public String format(String input) {
        return csvFormatter.formatText(input);
    }
}
