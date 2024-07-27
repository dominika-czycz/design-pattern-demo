package com.patterns.demo.behavioral.interpreter;

public record NumberExpression(int number) implements Expression {

    @Override
    public int interpret(Context ctx) {
        return number;
    }
}
