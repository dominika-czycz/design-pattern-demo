package com.patterns.demo.behavioral.state.first;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
class Sleep implements TVState {
    private final TV tv;

    @Override
    public void logStatus() {
        log.info("TV {} is in sleep mode", tv.getModel());
    }

    @Override
    public TVMode getMode() {
        return TVMode.SLEEP;
    }
}
