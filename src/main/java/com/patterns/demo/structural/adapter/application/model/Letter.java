package com.patterns.demo.structural.adapter.application.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Letter {

    private String heading;
    private String recipientsAddress;
    private String salutation;
    private String body;
    private String signature;
    private String composition;

}
