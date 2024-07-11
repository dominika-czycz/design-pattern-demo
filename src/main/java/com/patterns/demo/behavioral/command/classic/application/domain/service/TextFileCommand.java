package com.patterns.demo.behavioral.command.classic.application.domain.service;

@FunctionalInterface
public interface TextFileCommand {
    String execute();
}
