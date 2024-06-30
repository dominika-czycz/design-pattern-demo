package com.patterns.demo.creational.prototype.good;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class AuthorizedSignatory {
    private final @NonNull String name;
    private final @NonNull String designation;

    public AuthorizedSignatory(AuthorizedSignatory other) {
        this(other.getName(), other.getDesignation());
    }
}
