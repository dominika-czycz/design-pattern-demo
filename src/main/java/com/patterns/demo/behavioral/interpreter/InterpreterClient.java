package com.patterns.demo.behavioral.interpreter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InterpreterClient {
    private final Context context;

    public int process(Expression expression) {
        return expression.interpret(context);
    }

}
