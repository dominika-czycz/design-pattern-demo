package com.patterns.demo.behavioral.observer.springevents.channel.adpater.out.persitance;

import com.patterns.demo.behavioral.observer.springevents.channel.model.NewsChannel;
import com.patterns.demo.behavioral.observer.springevents.channel.port.out.NewsChannelRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class NewsChannelInMemoryRepository implements NewsChannelRepository {
    private final List<NewsChannel> newsChannels = new ArrayList<>();

    @Override
    public List<NewsChannel> findAllInterestedChannels() {
        return newsChannels;
    }

    @Override
    public void add(NewsChannel newsChannel) {
        newsChannels.add(newsChannel);
    }
}
