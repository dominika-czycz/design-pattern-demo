package com.patterns.demo.structural.adapter.application.service;


import com.patterns.demo.structural.adapter.application.model.Letter;
import com.patterns.demo.structural.adapter.external.CsvFormatterImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {ClosedForChangesClient.class, AdapterFormatter.class, CsvFormatterImpl.class})
class ClosedForChangesClientIntegrationTest {
    @Autowired
    private ClosedForChangesClient closedForChangesClient;

    @Test
    void shouldFormatLetterBody() {
        // given
        Letter letter = new Letter();
        letter.setBody("to.be.formatted");

        // when
        closedForChangesClient.formatDocument(letter);

        // then
        assertThat(letter.getBody()).isEqualTo("to,be,formatted");
    }
}
