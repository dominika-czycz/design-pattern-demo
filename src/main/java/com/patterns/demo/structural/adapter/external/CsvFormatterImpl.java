package com.patterns.demo.structural.adapter.external;

import org.springframework.stereotype.Service;

@Service
public class CsvFormatterImpl implements CsvFormatter {

    @Override
    public String formatText(String text) {
        return text.replace(".", ",");
    }
}
