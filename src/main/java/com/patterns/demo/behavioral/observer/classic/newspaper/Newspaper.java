package com.patterns.demo.behavioral.observer.classic.newspaper;

import com.patterns.demo.behavioral.observer.classic.common.Observer;

import java.util.ArrayList;
import java.util.List;

public class Newspaper implements Observer<String> {
    private final List<String> news = new ArrayList<>();

    @Override
    public void update(String event) {
        news.add(event);
    }

    public List<String> getNews() {
        return List.copyOf(news);
    }
}
