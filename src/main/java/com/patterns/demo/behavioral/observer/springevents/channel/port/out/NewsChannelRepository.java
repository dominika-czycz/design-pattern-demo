package com.patterns.demo.behavioral.observer.springevents.channel.port.out;

import com.patterns.demo.behavioral.observer.springevents.channel.model.NewsChannel;

import java.util.List;

public interface NewsChannelRepository {

    List<NewsChannel> findAllInterestedChannels();

    void add(NewsChannel newsChannel);
}
