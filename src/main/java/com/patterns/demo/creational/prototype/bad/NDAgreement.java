package com.patterns.demo.creational.prototype.bad;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NDAgreement implements Cloneable {
    private List<AuthorizedSignatory> authorizedSignatories;
    private String vendorName;
    private String content;

    @Override
    public NDAgreement clone() {
        try {
            NDAgreement clone = (NDAgreement) super.clone();
            clone.authorizedSignatories = clone.authorizedSignatories.stream().map(AuthorizedSignatory::clone).toList();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public NDAgreement shallowClone() {
        try {
            return (NDAgreement) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
