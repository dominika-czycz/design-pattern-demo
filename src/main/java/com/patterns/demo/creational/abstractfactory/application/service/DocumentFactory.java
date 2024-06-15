package com.patterns.demo.creational.abstractfactory.application.service;

import com.patterns.demo.creational.abstractfactory.application.model.Formatter;
import com.patterns.demo.creational.abstractfactory.application.model.Letter;
import com.patterns.demo.creational.abstractfactory.application.model.Resume;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class DocumentFactory {

    private final Formatter formatter;

    public abstract Letter createLetter();

    public abstract Resume createResume();
}
