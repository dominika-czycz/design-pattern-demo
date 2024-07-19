package com.patterns.demo.behavioral.state.second;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ReceivedState extends PackageState {

    public ReceivedState(Package aPackage) {
        super(aPackage);
    }

    @Override
    public void prev() {
        aPackage.setCurrentPackageState(new DeliveredState(aPackage));
    }

    @Override
    public void next() {
        log.warn("No next state for {}", this.getClass().getSimpleName());
    }

    @Override
    public PackageStatus getPackageStatus() {
        return PackageStatus.RECEIVED;
    }
}
