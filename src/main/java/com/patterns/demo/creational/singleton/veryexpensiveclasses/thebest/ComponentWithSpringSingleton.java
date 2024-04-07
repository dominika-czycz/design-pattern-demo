package com.patterns.demo.creational.singleton.veryexpensiveclasses.thebest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class ComponentWithSpringSingleton {
    private final SpringSingleton springSingleton;
}
