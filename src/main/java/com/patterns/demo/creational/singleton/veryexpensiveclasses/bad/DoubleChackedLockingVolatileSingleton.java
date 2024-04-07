package com.patterns.demo.creational.singleton.veryexpensiveclasses.bad;

import lombok.extern.slf4j.Slf4j;

/*
  Performance drop, memory consolidation 😔
 */
@Slf4j
public class DoubleChackedLockingVolatileSingleton {
    private static volatile DoubleChackedLockingVolatileSingleton instance;

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
