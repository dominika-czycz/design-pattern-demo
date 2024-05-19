package com.patterns.demo.creational.singleton.veryexpensiveclasses.bad;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
  Performance drop, memory consolidation 😔
 */
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DoubleChackedLockingVolatileSingleton {
    private static volatile DoubleChackedLockingVolatileSingleton instance;

    //    expensive fields here

    public static DoubleChackedLockingVolatileSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleChackedLockingVolatileSingleton.class) {
                if (instance == null) {
                    instance = new DoubleChackedLockingVolatileSingleton();
                }
            }

        }
        return instance;
    }

    public void doSomething() {
        log.info("I did it again");
    }
}
