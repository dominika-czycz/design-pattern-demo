package com.patterns.demo.structural.bridge;


import com.patterns.demo.structural.bridge.application.service.EmailMessageService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BridgeClientTest {
    @Test
    void shouldSendEmailMessage() {
        // given
        EmailMessageService messageService = mock(EmailMessageService.class);
        BridgeClient bridgeClient = new BridgeClient(messageService);
        // when
        String to = "testto@demo.eu";
        String from = "testfrom@demo.eu";
        bridgeClient.sendMessage(to, from);
        // then
        verify(messageService).sendDefaultMessage(to, from);

    }
}
