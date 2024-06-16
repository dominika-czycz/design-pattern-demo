package com.patterns.demo.creational.builder.gof.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean furnished;
    private boolean painted;
}
