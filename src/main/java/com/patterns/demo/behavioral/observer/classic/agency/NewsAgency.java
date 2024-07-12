package com.patterns.demo.behavioral.observer.classic.agency;

import com.patterns.demo.behavioral.observer.classic.common.Observer;
import com.patterns.demo.behavioral.observer.classic.common.Subject;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject<String> {
    private final List<String> news = new ArrayList<>();
    private final List<Observer<String>> observers = new ArrayList<>();

    public void addToNews(String news) {
        this.news.add(news);
        notifyObservers(news);
    }

    @Override
    public void addObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        observers.forEach(observer -> observer.update(event));

    }

    public List<String> getNews() {
        return List.copyOf(news);
    }
}
