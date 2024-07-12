package com.patterns.demo.behavioral.observer.springevents.channel.model;

import java.util.ArrayList;
import java.util.List;

public class NewsChannel {
    private final List<String> news = new ArrayList<>();

    public void update(String event) {
        this.news.add(event);
    }

    public List<String> getNews() {
        return List.copyOf(news);
    }
}
