package com.patterns.demo.creational.builder.gof.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DetachedHouse extends House {
    private Boolean fieldSpecificForDetachedHouse;
}
