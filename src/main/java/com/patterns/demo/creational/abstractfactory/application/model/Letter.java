package com.patterns.demo.creational.abstractfactory.application.model;


import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

@Getter
public abstract class Letter implements Composable {

    @Setter
    private String heading;
    @Setter
    private String recipientsAddress;
    @Setter
    private String salutation;
    private String body;
    @Setter
    private String complimentaryClose;
    @Setter
    private String signature;
    @Setter
    private String composition;


    public void addToBody(String text) {
        this.body = this.body + text;
    }

    @Override
    public void compose() {
        String basicComposition = new StringJoiner(", ")
                .add("heading='" + heading + "'")
                .add("recipientsAddress='" + recipientsAddress + "'")
                .add("salutation='" + salutation + "'")
                .add("body='" + body + "'")
                .add("complimentaryClose='" + complimentaryClose + "'")
                .add("signature='" + signature + "'")
                .add("composition='" + composition + "'")
                .toString();
        this.composition = this.addSpecificFields(basicComposition);
    }

    protected abstract String addSpecificFields(String basicComposition);
}
