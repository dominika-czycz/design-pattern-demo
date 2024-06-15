package com.patterns.demo.creational.abstractfactory.application.model;

public interface Formatter {

    void format(Letter letter);

    void format(Resume resume);
}
