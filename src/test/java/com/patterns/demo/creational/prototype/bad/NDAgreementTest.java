package com.patterns.demo.creational.prototype.bad;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NDAgreementTest {
    @Test
    void shouldDeepClone() {
        // given
        AuthorizedSignatory authorizedSignatory1 = new AuthorizedSignatory("Jan Kowalski", "Operation Head");
        AuthorizedSignatory authorizedSignatory2 = new AuthorizedSignatory("Anna Nowak", "CEO");
        NDAgreement ndAgreement = new NDAgreement();
        ndAgreement.setVendorName("Vendor Name Placeholder");
        ndAgreement.setContent("Content Placeholder");
        ndAgreement.setAuthorizedSignatories(List.of(authorizedSignatory1, authorizedSignatory2));

        // when
        NDAgreement clonedNdAgreement = ndAgreement.clone();


        // then
        assertThat(clonedNdAgreement).isNotEqualTo(ndAgreement);
        assertThat(clonedNdAgreement).usingRecursiveComparison().isEqualTo(ndAgreement);
        assertThat(clonedNdAgreement.getAuthorizedSignatories()).doesNotContainAnyElementsOf(ndAgreement.getAuthorizedSignatories());
        assertThat(clonedNdAgreement.getAuthorizedSignatories()).usingRecursiveComparison().isEqualTo(ndAgreement.getAuthorizedSignatories());
    }

    @Test
    void shouldShallowClone() {
        // given
        AuthorizedSignatory authorizedSignatory1 = new AuthorizedSignatory("Jan Kowalski", "Operation Head");
        AuthorizedSignatory authorizedSignatory2 = new AuthorizedSignatory("Anna Nowak", "CEO");
        NDAgreement ndAgreement = new NDAgreement();
        ndAgreement.setVendorName("Vendor Name Placeholder");
        ndAgreement.setContent("Content Placeholder");
        ndAgreement.setAuthorizedSignatories(List.of(authorizedSignatory1, authorizedSignatory2));

        // when
        NDAgreement clonedNdAgreement = ndAgreement.shallowClone();

        // then
        assertThat(clonedNdAgreement).isNotEqualTo(ndAgreement);
        assertThat(clonedNdAgreement).usingRecursiveComparison().isEqualTo(ndAgreement);
        assertThat(clonedNdAgreement.getAuthorizedSignatories()).containsExactlyInAnyOrderElementsOf(ndAgreement.getAuthorizedSignatories());
    }
}
