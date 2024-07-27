package com.patterns.demo.behavioral.interpreter;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InterpreterClientTest {

    @Test
    void shouldProcessComplexExpression() {
        Expression expression = new MultiplicationExpression(
                new NumberExpression(-2), new AdditionExpression(
                new NumberExpression(10), new MultiplicationExpression(
                new NumberExpression(2), new NumberExpression(3))));

        InterpreterClient interpreterClient = new InterpreterClient(new Context(true));
        int result = interpreterClient.process(expression);
        assertThat(result).isEqualTo(-32);
    }
}
