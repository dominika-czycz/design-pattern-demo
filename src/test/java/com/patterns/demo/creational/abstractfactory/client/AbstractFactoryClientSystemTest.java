package com.patterns.demo.creational.abstractfactory.client;

import com.patterns.demo.creational.abstractfactory.application.model.Composable;
import com.patterns.demo.creational.abstractfactory.application.model.Letter;
import com.patterns.demo.creational.abstractfactory.application.model.Resume;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
class AbstractFactoryClientSystemTest {

    private static final String EXPECTED_LETTER_COMPOSITION = """
            heading='some heading', recipientsAddress='null', salutation='some salutation', \
            body='null', complimentaryClose='some compliment close', signature='null', \
            composition='heading='null', recipientsAddress='null', salutation='null', \
            body='null', complimentaryClose='null', signature='null', composition='null', Fancy Letter', Fancy Letter""";
    private static final String EXPECTED_RESUME_COMPOSITION = """
            personalInformation='some personal information', objective='some objective', \
            education=null, experience=null, awards=null, hobbies=null, composition='null', Fancy resume specific field""";

    @Autowired
    private AbstractFactoryClient abstractFactoryClient;

    @Test
    void shouldReturnProperlyFormatedLetterAndResume() {
        //given //when //then
        List<Composable> documents = abstractFactoryClient.prepareDocumentsDrafts();
        assertThat(documents).isNotEmpty().hasSize(2);

        Optional<Composable> letter = documents.stream().filter(composable -> composable instanceof Letter).findFirst();
        assertThat(letter).isPresent().get()
                .extracting(l -> ((Letter) l).getComposition()).isEqualTo(EXPECTED_LETTER_COMPOSITION);

        Optional<Composable> resume = documents.stream().filter(composable -> composable instanceof Resume).findFirst();
        assertThat(resume).isPresent().get()
                .extracting(res -> ((Resume) res).getComposition()).isEqualTo(EXPECTED_RESUME_COMPOSITION);


    }

}
