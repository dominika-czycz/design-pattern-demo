package com.patterns.demo.creational.abstractfactory.fancylibrary;

import com.patterns.demo.creational.abstractfactory.application.model.Resume;

class FancyResume extends Resume {

    private static final String FANCY_RESUME_SPECIFIC_FIELD = "Fancy resume specific field";

    @Override
    protected String addSpecificFields(String basicComposition) {
        return basicComposition + ", " + FANCY_RESUME_SPECIFIC_FIELD;
    }
}
