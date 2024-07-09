package com.patterns.demo.creational.singleton.veryexpensiveclasses.thebest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*
With Spring beans, we can inject an object into the Spring Container through metadata using inversion of control (IoC).
In effect, an object can define its dependencies without creating them and delegate that work to the IoC Container.
Bean Scope
The latest version of the Spring framework defines six types of scopes:
singleton -> default
prototype
request
session
application
websocket
https://www.baeldung.com/spring-bean-scopes
https://www.baeldung.com/spring-boot-singleton-vs-beans
https://www.baeldung.com/spring-singleton-concurrent-requests
 */
@Slf4j
@Component
public class SpringSingleton {
    public void doSomething() {
        log.info("I did it again");
    }
}
