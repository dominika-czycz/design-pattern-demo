package com.patterns.demo.behavioral.observer.springevents.agency.model;


import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private final List<String> news = new ArrayList<>();

    public void addToNews(String news) {
        this.news.add(news);
    }

    public List<String> getNews() {
        return List.copyOf(news);
    }
}
