package com.patterns.demo.creational.singleton.veryexpensiveclasses.bad;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/*
No lazy loading 😔
 */
@Slf4j
public class EagerSingleton {
    @Getter
    private static final EagerSingleton instance = new EagerSingleton();

    public void doSomething() {
        log.info("I did it again");
    }

}
