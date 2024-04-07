package com.patterns.demo.creational.singleton.veryexpensiveclasses.bad;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/*
This code allow to create more than one object.
How/When is it possible?
How to prevent this?
How to efficiently prevent this? 🤔
 */
@Slf4j
public class Singleton {
    private static Singleton instance;
    private static int count = 0;

    private Singleton() {
    }

    @SneakyThrows
    public static Singleton getInstance() {
        if (instance == null) {
            if (count == 0) {
                count++;
                Thread.sleep(100);
            }
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        log.info("I did it again");
    }
}
