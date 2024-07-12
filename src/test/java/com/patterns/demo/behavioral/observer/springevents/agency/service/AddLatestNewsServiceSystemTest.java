package com.patterns.demo.behavioral.observer.springevents.agency.service;

import com.patterns.demo.behavioral.observer.springevents.agency.model.NewsAgency;
import com.patterns.demo.behavioral.observer.springevents.channel.model.NewsChannel;
import com.patterns.demo.behavioral.observer.springevents.channel.port.out.NewsChannelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddLatestNewsServiceSystemTest {
    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsChannelRepository newsChannelRepository;

    @Test
    void newsAgencyAndNewsChannelShouldBeSynchronized() {
        // given
        NewsChannel newsChannel = new NewsChannel();
        newsChannelRepository.add(newsChannel);

        String latestNews = "latest news";
        NewsAgency newsAgency = new NewsAgency();

        // when
        newsService.addNews(newsAgency, latestNews);

        // then
        assertThat(newsChannel.getNews()).containsExactlyElementsOf(newsAgency.getNews());
    }
}
