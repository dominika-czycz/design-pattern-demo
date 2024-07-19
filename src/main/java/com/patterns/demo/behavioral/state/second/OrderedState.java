package com.patterns.demo.behavioral.state.second;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class OrderedState extends PackageState {

    public OrderedState(Package aPackage) {
        super(aPackage);
    }

    @Override
    public void prev() {
        log.warn("No previous state for {}", this.getClass().getSimpleName());
    }

    @Override
    public void next() {
        aPackage.setCurrentPackageState(new DeliveredState(aPackage));
    }


    @Override
    public PackageStatus getPackageStatus() {
        return PackageStatus.ORDERED;
    }
}
