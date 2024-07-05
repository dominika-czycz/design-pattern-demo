package com.patterns.demo.structural.proxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class LazyLoadingProxy implements Image {
    private final String fileName;
    private Image image;

    @Override
    public void display() {
        getInstance(fileName).display();
    }

    @Override
    public boolean isLoaded() {
        return image != null;
    }

    private Image getInstance(String fileName) {
        if (image == null) {
            image = new RealImage(fileName);
        }
        return image;
    }

}
