package com.patterns.demo.behavioral.observer.classic.freelancer;


import com.patterns.demo.behavioral.observer.classic.channel.NewsChannel;
import com.patterns.demo.behavioral.observer.classic.newspaper.Newspaper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FreelanceJournalistIntegrationTest {

    @Test
    void shouldSynchronizeWithAllObserver() {
        // given
        NewsChannel newsChannel = new NewsChannel();
        Newspaper newspaper = new Newspaper();

        FreelanceJournalist journalist = new FreelanceJournalist();
        journalist.addObserver(newsChannel);
        journalist.addObserver(newspaper);

        // when
        String latestNews = "latest news";
        journalist.addToNews(latestNews);

        // then
        assertThat(journalist.getNews())
                .containsExactlyElementsOf(List.of(latestNews))
                .containsExactlyElementsOf(newspaper.getNews())
                .containsExactlyElementsOf(newsChannel.getNews());
    }

    @Test
    void removedObserverShouldNotBeSynchronized() {
        // given
        NewsChannel newsChannel = new NewsChannel();
        Newspaper newspaper = new Newspaper();

        FreelanceJournalist journalist = new FreelanceJournalist();
        journalist.addObserver(newsChannel);
        journalist.addObserver(newspaper);
        journalist.removeObserver(newsChannel);

        // when
        String latestNews = "latest news";
        journalist.addToNews(latestNews);

        // then
        assertThat(journalist.getNews())
                .containsExactlyElementsOf(List.of(latestNews))
                .containsExactlyElementsOf(newspaper.getNews());
        assertThat(newsChannel.getNews()).doesNotContainAnyElementsOf(journalist.getNews());
    }

}
