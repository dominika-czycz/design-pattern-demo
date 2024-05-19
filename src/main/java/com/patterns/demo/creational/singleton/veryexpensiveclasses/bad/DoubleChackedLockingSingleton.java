package com.patterns.demo.creational.singleton.veryexpensiveclasses.bad;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
JIT or CPU optimizations can mess up this implementation 😯
 */
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DoubleChackedLockingSingleton {
    private static DoubleChackedLockingSingleton instance;

    //    expensive fields here

    public static DoubleChackedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleChackedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleChackedLockingSingleton();
                }
            }

        }
        return instance;
    }

    public void doSomething() {
        log.info("I did it again");
    }
}
