package com.patterns.demo.creational.factorymethod.withenum.application.model;

public enum DocumentType {

    TEXT {
        @Override
        public Document createDocument() {
            return new TextDocument();
        }
    }, WORD {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    };

    public abstract Document createDocument();
}
