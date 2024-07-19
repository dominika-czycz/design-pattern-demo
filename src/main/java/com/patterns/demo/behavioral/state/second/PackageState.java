package com.patterns.demo.behavioral.state.second;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class PackageState {
    protected final Package aPackage;

    public abstract void prev();

    public abstract void next();

    public abstract PackageStatus getPackageStatus();

    public void logStatus() {
        log.info("Package {} is {} ", aPackage.getIdentifier(), getPackageStatus());
    }
}
