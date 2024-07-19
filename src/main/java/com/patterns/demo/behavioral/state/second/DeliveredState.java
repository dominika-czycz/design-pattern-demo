package com.patterns.demo.behavioral.state.second;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DeliveredState extends PackageState {

    public DeliveredState(Package aPackage) {
        super(aPackage);
    }

    @Override
    public void prev() {
        aPackage.setCurrentPackageState(new OrderedState(aPackage));
    }

    @Override
    public void next() {
        aPackage.setCurrentPackageState(new ReceivedState(aPackage));
    }

    @Override
    public PackageStatus getPackageStatus() {
        return PackageStatus.DELIVERED;
    }
}
