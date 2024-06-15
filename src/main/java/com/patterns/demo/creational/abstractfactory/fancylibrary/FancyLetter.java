package com.patterns.demo.creational.abstractfactory.fancylibrary;

import com.patterns.demo.creational.abstractfactory.application.model.Letter;

class FancyLetter extends Letter {

    private static final String FANCY_LETTER_SPECIFIC_FIELD = "Fancy Letter";

    @Override
    protected String addSpecificFields(String basicComposition) {
        return basicComposition + ", " + FANCY_LETTER_SPECIFIC_FIELD;
    }

}
