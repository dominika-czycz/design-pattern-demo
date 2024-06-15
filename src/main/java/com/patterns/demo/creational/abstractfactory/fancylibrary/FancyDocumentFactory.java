package com.patterns.demo.creational.abstractfactory.fancylibrary;

import com.patterns.demo.creational.abstractfactory.application.model.Formatter;
import com.patterns.demo.creational.abstractfactory.application.model.Letter;
import com.patterns.demo.creational.abstractfactory.application.model.Resume;
import com.patterns.demo.creational.abstractfactory.application.service.DocumentFactory;
import org.springframework.stereotype.Service;

@Service
class FancyDocumentFactory extends DocumentFactory {

    public FancyDocumentFactory(Formatter formatter) {
        super(formatter);
    }

    @Override
    public Letter createLetter() {
        return new FancyLetter();
    }

    @Override
    public Resume createResume() {
        return new FancyResume();
    }
}
