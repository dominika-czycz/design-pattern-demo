package com.patterns.demo.creational.abstractfactory.client;

import com.patterns.demo.creational.abstractfactory.application.model.Composable;
import com.patterns.demo.creational.abstractfactory.application.model.Formatter;
import com.patterns.demo.creational.abstractfactory.application.model.Letter;
import com.patterns.demo.creational.abstractfactory.application.model.Resume;
import com.patterns.demo.creational.abstractfactory.application.service.DocumentFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbstractFactoryClient {
    public static final String DEFAULT_OBJECTIVE = "some objective";
    public static final String DEFAULT_PERSONAL_INFORMATION = "some personal information";
    private static final String DEFAULT_HEADING = "some heading";
    private static final String DEFAULT_SALUTATION = "some salutation";
    private static final String DEFAULT_COMPLIMENTARY_CLOSE = "some compliment close";
    private final DocumentFactory documentFactory;

    public List<Composable> prepareDocumentsDrafts() {
        Formatter formatter = documentFactory.getFormatter();

        Letter letter = prepareLetter();
        formatter.format(letter);

        Resume resume = prepareResume();
        formatter.format(resume);

        return List.of(letter, resume);
    }

    private Resume prepareResume() {
        Resume resume = documentFactory.createResume();
        resume.setObjective(DEFAULT_OBJECTIVE);
        resume.setPersonalInformation(DEFAULT_PERSONAL_INFORMATION);
        resume.compose();
        return resume;
    }

    private Letter prepareLetter() {
        Letter letter = documentFactory.createLetter();
        letter.compose();
        letter.setHeading(DEFAULT_HEADING);
        letter.setSalutation(DEFAULT_SALUTATION);
        letter.setComplimentaryClose(DEFAULT_COMPLIMENTARY_CLOSE);
        letter.compose();
        return letter;
    }
}
