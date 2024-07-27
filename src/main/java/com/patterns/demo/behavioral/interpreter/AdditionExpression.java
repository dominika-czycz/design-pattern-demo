package com.patterns.demo.behavioral.interpreter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record AdditionExpression(Expression left, Expression right) implements Expression {
    @Override
    public int interpret(Context ctx) {
        if (ctx.shouldLog()) {
            log.info("addition expression of {} and {}", left, right);
        }
        return left.interpret(ctx) + right.interpret(ctx);
    }
}
