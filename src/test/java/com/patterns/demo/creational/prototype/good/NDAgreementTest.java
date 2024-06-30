package com.patterns.demo.creational.prototype.good;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NDAgreementTest {

    @Test
    void shouldDeepClone() {
        // given
        AuthorizedSignatory authorizedSignatory1 = new AuthorizedSignatory("Jan Kowalski", "Operation Head");
        AuthorizedSignatory authorizedSignatory2 = new AuthorizedSignatory("Anna Nowak", "CEO");
        NDAgreement ndAgreement = new NDAgreement(
                "Vendor Name Placeholder",
                "Content Placeholder",
                List.of(authorizedSignatory1, authorizedSignatory2));

        // when
        NDAgreement clonedNdAgreement = new NDAgreement(ndAgreement);

        // then
        assertThat(clonedNdAgreement).isNotEqualTo(ndAgreement);
        assertThat(clonedNdAgreement).usingRecursiveComparison().isEqualTo(ndAgreement);
        assertThat(clonedNdAgreement.getAuthorizedSignatories()).doesNotContainAnyElementsOf(ndAgreement.getAuthorizedSignatories());
        assertThat(clonedNdAgreement.getAuthorizedSignatories()).usingRecursiveComparison().isEqualTo(ndAgreement.getAuthorizedSignatories());
    }
}
