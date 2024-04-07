package com.patterns.demo.creational.singleton.veryexpensiveclasses.bad;

import lombok.extern.slf4j.Slf4j;

/*
JIT or CPU optimizations can mess up this implementation 😯
 */
@Slf4j
public class DoubleChackedLockingSingleton {
    private static DoubleChackedLockingSingleton instance;

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

    public void doSomething(){
        log.info("I did it again");
    }
}
