package com.patterns.demo.behavioral.observer.springevents.channel.adpater.in.event;

import com.patterns.demo.behavioral.observer.springevents.channel.port.in.AddLatestNewsUseCase;
import com.patterns.demo.behavioral.observer.springevents.common.LatestNewsEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class LatestNewsEventListener {

    private final AddLatestNewsUseCase addLatestNewsUseCase;

    @EventListener
    public void listenOn(LatestNewsEvent event) {
        addLatestNewsUseCase.add(event.news());
    }
}
