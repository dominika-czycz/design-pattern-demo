package com.patterns.demo.creational.prototype.good;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public final class NDAgreement {
    private final String vendorName;
    private final String content;
    private final @NonNull List<AuthorizedSignatory> authorizedSignatories;

    public NDAgreement(@NonNull NDAgreement other) {
        this(other.vendorName, other.content, other.authorizedSignatories.stream()
                .map(AuthorizedSignatory::new).toList());

    }
}
