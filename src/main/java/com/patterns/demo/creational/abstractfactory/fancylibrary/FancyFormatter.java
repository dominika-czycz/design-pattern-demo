package com.patterns.demo.creational.abstractfactory.fancylibrary;

import com.patterns.demo.creational.abstractfactory.application.model.Formatter;
import com.patterns.demo.creational.abstractfactory.application.model.Letter;
import com.patterns.demo.creational.abstractfactory.application.model.Resume;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
class FancyFormatter implements Formatter {

    private static final String SOME_FORMAT_RELATED_DATA = "some format related data";

    @Override
    public void format(Letter letter) {
        log.info("Formatting letter {} using config data {}", letter, SOME_FORMAT_RELATED_DATA);
        //formatting logic here
    }

    @Override
    public void format(Resume resume) {
        log.info("Formatting resume {} using config data {}", resume, SOME_FORMAT_RELATED_DATA);
        //formatting logic here
    }
}
