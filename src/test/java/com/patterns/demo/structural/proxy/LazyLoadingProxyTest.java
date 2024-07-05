package com.patterns.demo.structural.proxy;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LazyLoadingProxyTest {

    @Test
    void shouldNotLoadImage() {
        // given + when
        LazyLoadingProxy lazyLoadingProxy = new LazyLoadingProxy("fileName");
        // then
        assertThat(lazyLoadingProxy.isLoaded()).isFalse();
    }

    @Test
    void shouldLoadImage() {
        // given + when
        LazyLoadingProxy lazyLoadingProxy = new LazyLoadingProxy("fileName");
        lazyLoadingProxy.display();
        // then
        assertThat(lazyLoadingProxy.isLoaded()).isTrue();
    }
}
