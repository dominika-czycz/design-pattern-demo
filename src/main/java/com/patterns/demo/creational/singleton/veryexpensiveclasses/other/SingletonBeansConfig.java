package com.patterns.demo.creational.singleton.veryexpensiveclasses.other;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
/*
Unlike the pure singleton design pattern, we can create multiple singleton beans from the same class
All requests for beans with a matching identifier will result in one specific bean instance being returned by the framework.
When we use the @Bean annotation on a method, Spring uses the method name as a bean identifier.
 */
public class SingletonBeansConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SingletonBean anotherSingletonBean() {
        return new SingletonBean();
    }
}
