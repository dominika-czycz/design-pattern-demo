package com.patterns.demo.structural.bridge.application.service;

import com.patterns.demo.structural.bridge.application.domain.EmailMessage;
import com.patterns.demo.structural.bridge.infrastructure.EmailMessageSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EmailMessageServiceTest {
    private final EmailMessageSender messageSender = mock(EmailMessageSender.class);
    private EmailMessageService emailMessageService;

    @BeforeEach
    void setUp() {
        emailMessageService = new EmailMessageService(messageSender);
    }

    @Test
    void shouldSendDefaultEmail() {
        // given
        String from = "from@test.com";
        String to = "to@test.com";

        // when
        emailMessageService.sendDefaultMessage(from, to);

        // then
        ArgumentCaptor<EmailMessage> captor = ArgumentCaptor.forClass(EmailMessage.class);
        verify(messageSender).sendMessage(captor.capture());
        EmailMessage emailMessage = captor.getValue();
        assertThat(emailMessage).isNotNull()
                .extracting(EmailMessage::getBody).isEqualTo("Hello");
        assertThat(emailMessage).extracting(EmailMessage::getFrom).isEqualTo(from);
        assertThat(emailMessage).extracting(EmailMessage::getTo).isEqualTo(to);
    }
}
