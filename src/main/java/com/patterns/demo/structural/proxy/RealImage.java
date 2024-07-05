package com.patterns.demo.structural.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class RealImage implements Image {
    private final String fileName;
    private boolean isLoaded;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromFile();
    }

    @Override
    public void display() {
        log.info("Display image file: {}", fileName);
    }

    @Override
    public boolean isLoaded() {
        return isLoaded;
    }

    private void loadFromFile() {
        log.info("Load image from file: {}", fileName);
        isLoaded = true;
    }

}
