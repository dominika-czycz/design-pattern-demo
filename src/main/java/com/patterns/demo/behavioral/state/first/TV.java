package com.patterns.demo.behavioral.state.first;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/*
 * Context decides which state succeeds.
 * */
@Getter
@RequiredArgsConstructor
public class TV {
    private final String model;

    //some other fields related to Package here

    @NonNull
    private TVState currentState = new Off(this);

    public void pressOnButton() {
        this.currentState = new On(this);
    }

    public void pressSleepButton() {
        if (this.currentState.getMode() == TVMode.ON) {
            this.currentState = new Sleep(this);
        }
    }

    public void pressOffButton() {
        this.currentState = new Off(this);
    }

    public void logTvStatus() {
        currentState.logStatus();
    }

    public TVMode getTVMode() {
        return currentState.getMode();
    }

}
