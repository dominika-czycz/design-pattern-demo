package com.patterns.demo.creational.singleton.veryexpensiveclasses.bad;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
No lazy loading 😔
 */
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EagerSingleton {
    @Getter
    private static final EagerSingleton instance = new EagerSingleton();

    //    expensive fields here


    public void doSomething() {
        log.info("I did it again");
    }

}
