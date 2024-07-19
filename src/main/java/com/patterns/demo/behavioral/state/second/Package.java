package com.patterns.demo.behavioral.state.second;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
 * Concrete states decide which state succeeds.
 * */
@Getter
@RequiredArgsConstructor
public class Package {
    private final String identifier;

    //some other fields related to Package here

    @NonNull
    @Setter
    private PackageState currentPackageState = new OrderedState(this);

    public void moveToPreviousState() {
        currentPackageState.prev();
    }

    public void moveToNextState() {
        currentPackageState.next();
    }

    public void logPackageStatus() {
        currentPackageState.logStatus();
    }

    public PackageStatus getPackageState() {
        return this.currentPackageState.getPackageStatus();
    }

}
