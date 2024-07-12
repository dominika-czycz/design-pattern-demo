package com.patterns.demo.behavioral.memento.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class TextDocument {

    @Setter
    @NonNull
    private String title;
    private String content = "";

    public TextDocument(@NonNull String title) {
        this.title = title;
    }

    public void write(String text) {
        this.content += text;
    }

    public TextDocumentMemento createMemento() {
        return new TextDocumentMemento(this.title, this.content);
    }

    public void restoreFromMemento(TextDocumentMemento memento) {
        this.content = memento.content();
    }
}
