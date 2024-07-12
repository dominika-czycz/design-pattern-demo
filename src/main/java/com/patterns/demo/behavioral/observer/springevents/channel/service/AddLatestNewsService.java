package com.patterns.demo.behavioral.observer.springevents.channel.service;

import com.patterns.demo.behavioral.observer.springevents.channel.model.NewsChannel;
import com.patterns.demo.behavioral.observer.springevents.channel.port.in.AddLatestNewsUseCase;
import com.patterns.demo.behavioral.observer.springevents.channel.port.out.NewsChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddLatestNewsService implements AddLatestNewsUseCase {

    private final NewsChannelRepository channelRepository;

    @Override
    public void add(String news) {
        List<NewsChannel> allInterestedChannels = channelRepository.findAllInterestedChannels();
        allInterestedChannels.forEach(newsChannel -> newsChannel.update(news));
    }
}
