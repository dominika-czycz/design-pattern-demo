package com.patterns.demo.creational.prototype.bad;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorizedSignatory implements Cloneable {
    private final String name;
    private final String designation;

    @Override
    public AuthorizedSignatory clone() {
        try {
            return (AuthorizedSignatory) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
