package com.patterns.demo.behavioral.observer.classic.common;

public interface Observer<EVENT> {
    void update(EVENT event);
}
