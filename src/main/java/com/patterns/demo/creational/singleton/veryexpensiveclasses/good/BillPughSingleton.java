package com.patterns.demo.creational.singleton.veryexpensiveclasses.good;
/*
The class loader in a Java application loads the static inner class SingletonHelper in the memory only once,
even if multiple threads call getInstance().
+ Enables lazy loading
+ Eliminates the overhead of locking and unlocking objects while accessing the synchronized methods 💪
https://www.baeldung.com/java-bill-pugh-singleton-implementation
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.BILL_PUGH_SINGLETON_INSTANCE;
    }

    private static class SingletonHelper {
        private static final BillPughSingleton BILL_PUGH_SINGLETON_INSTANCE = new BillPughSingleton();
    }

    public void doSomething() {
        log.info("I did it again");
    }
}
