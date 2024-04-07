package com.patterns.demo.creational.singleton.veryexpensiveclasses.bad;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
/*
https://www.baeldung.com/java-concurrent-hashset-concurrenthashmap
https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/concurrent/ExecutorService.html#:~:text=Two%20different%20methods%20are%20provided,to%20stop%20currently%20executing%20tasks
 */

@Slf4j
class SingletonTest {
    @Test
    void callGetInstanceIsNotThreadSafe() {
        int threadNumber = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
        Set<Singleton> singletonObjects = ConcurrentHashMap.newKeySet();

        for (int i = 0; i < threadNumber; i++) {
            executorService.execute(() -> singletonObjects.add(Singleton.getInstance()));
        }

        shutdownAndAwaitTermination(executorService);

        assertThat(singletonObjects).hasSizeGreaterThan(1);
    }

    void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}