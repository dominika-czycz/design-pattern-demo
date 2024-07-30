package com.patterns.demo.structural.flyweight.application.service;


import com.patterns.demo.structural.flyweight.application.model.BasicCat;
import com.patterns.demo.structural.flyweight.application.model.CustomizedCat;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CustomizedAnimalFactoryIntegrationTest {
    private final BasicAnimalFactory basicAnimalFactory = new BasicAnimalFactory();
    private final CustomizedAnimalFactory customizedAnimalFactory = new CustomizedAnimalFactory(basicAnimalFactory);

    @Test
    void shouldContainTheSameBasicCat() {
        //given
        String biscuit = "Biscuit";
        String garfield = "Garfield";

        //when
        CustomizedCat cat1 = customizedAnimalFactory.createCustomizedCat(biscuit);
        CustomizedCat cat2 = customizedAnimalFactory.createCustomizedCat(garfield);

        //then
        assertThat(cat1.basicCat()).isNotNull().isSameAs(cat2.basicCat());
    }

    @Test
    void shouldContainTheSameBasicCatWhenMultipleThread() {
        //given
        int threadCount = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<BasicCat> basicCats = new CopyOnWriteArrayList<>();
        String biscuit = "Biscuit";

        //when
        IntStream.range(0, threadCount).forEach(i -> executorService.execute(() -> {
            CustomizedCat customizedCat = customizedAnimalFactory.createCustomizedCat(biscuit + 1);
            basicCats.add(customizedCat.basicCat());
        }));

        shutdownAndAwaitTermination(executorService);

        //then
        assertThat(basicCats).isNotEmpty();
        BasicCat first = basicCats.getFirst();
        assertThat(basicCats).hasSize(threadCount)
                .allMatch(basicCat -> basicCat == first);
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
