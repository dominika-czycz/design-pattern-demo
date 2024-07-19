package com.patterns.demo.behavioral.state.first;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
class On implements TVState {
    private final TV tv;

    @Override
    public void logStatus() {
        log.info("TV {} is on", tv.getModel());
    }

    @Override
    public TVMode getMode() {
        return TVMode.ON;
    }
}
