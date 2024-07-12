package com.patterns.demo.behavioral.observer.springevents.agency.service;

import com.patterns.demo.behavioral.observer.springevents.agency.model.NewsAgency;
import com.patterns.demo.behavioral.observer.springevents.common.LatestNewsEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final ApplicationEventPublisher eventPublisher;

    public void addNews(NewsAgency agency, String news) {
        agency.addToNews(news);
        eventPublisher.publishEvent(new LatestNewsEvent(news));
    }
}
