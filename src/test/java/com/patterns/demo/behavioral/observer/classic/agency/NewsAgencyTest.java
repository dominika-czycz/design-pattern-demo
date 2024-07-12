package com.patterns.demo.behavioral.observer.classic.agency;

import com.patterns.demo.behavioral.observer.classic.channel.NewsChannel;
import com.patterns.demo.behavioral.observer.classic.freelancer.FreelanceJournalist;
import com.patterns.demo.behavioral.observer.classic.newspaper.Newspaper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NewsAgencyTest {
    @Test
    void shouldSynchronizeWithAllObserver() {
        // given
        NewsChannel newsChannel = new NewsChannel();
        Newspaper newspaper = new Newspaper();

        NewsAgency newsAgency = new NewsAgency();
        newsAgency.addObserver(newsChannel);
        newsAgency.addObserver(newspaper);

        // when
        String latestNews = "latest news";
        newsAgency.addToNews(latestNews);

        // then
        assertThat(newsAgency.getNews())
                .containsExactlyElementsOf(List.of(latestNews))
                .containsExactlyElementsOf(newspaper.getNews())
                .containsExactlyElementsOf(newsChannel.getNews());
    }

    @Test
    void removedObserverShouldNotBeSynchronized() {
        // given
        NewsChannel newsChannel = new NewsChannel();
        Newspaper newspaper = new Newspaper();

        FreelanceJournalist newsAgency = new FreelanceJournalist();
        newsAgency.addObserver(newsChannel);
        newsAgency.addObserver(newspaper);
        newsAgency.removeObserver(newsChannel);

        // when
        String latestNews = "latest news";
        newsAgency.addToNews(latestNews);

        // then
        assertThat(newsAgency.getNews())
                .containsExactlyElementsOf(List.of(latestNews))
                .containsExactlyElementsOf(newspaper.getNews());
        assertThat(newsChannel.getNews()).doesNotContainAnyElementsOf(newsAgency.getNews());
    }


}
