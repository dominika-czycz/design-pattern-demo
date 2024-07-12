package com.patterns.demo.behavioral.observer.classic.common;


public interface Subject<EVENT> {

    void addObserver(Observer<EVENT> observer);

    void removeObserver(Observer<EVENT> observer);

    void notifyObservers(EVENT event);

}
