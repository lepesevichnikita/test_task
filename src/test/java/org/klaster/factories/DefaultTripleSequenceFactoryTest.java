package org.klaster.factories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.DefaultTripleBuilder;
import org.klaster.builders.DefaultTripleSequenceBuilder;
import org.klaster.interfaces.*;
import org.klaster.models.TripleSequence;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
public class DefaultTripleSequenceFactoryTest {
    static private DigitsRepository      digitsRepository;
    static private NamedOrdersRepository namedOrdersRepository;
    static private TripleBuilder         tripleBuilder;
    static private DefaultTripleFactory  tripleFactory;
    static private TripleSequenceBuilder tripleSequenceBuilder;
    static private TripleSequenceFactory tripleSequenceFactory;

    @BeforeAll
    static void init() {
        digitsRepository      = new DefaultDigitsRepositoryFactory().create();
        namedOrdersRepository = new DefaultNamedOrdersRepositoryFactory().create();
        tripleBuilder         = new DefaultTripleBuilder();
        tripleFactory         = new DefaultTripleFactory();
        tripleSequenceBuilder = new DefaultTripleSequenceBuilder();
        tripleSequenceFactory = new DefaultTripleSequenceFactory();

        tripleFactory.setDigitsRepository(digitsRepository);
        tripleFactory.setTripleBuilder(tripleBuilder);
        tripleSequenceFactory.setNamedOrdersRepository(namedOrdersRepository);
        tripleSequenceFactory.setTripleFactory(tripleFactory);
        tripleSequenceFactory.setTripleSequenceBuilder(tripleSequenceBuilder);
    }

    static Stream<Arguments> sequences() {
        return Stream.of(
                Arguments.of("123", 1),
                Arguments.of("000", 1),
                Arguments.of("00", 1),
                Arguments.of("0", 1),
                Arguments.of("1000", 1),
                Arguments.of("1234000111", 3)
        );
    }

    @ParameterizedTest
    @DisplayName("Creates triple sequences with expected count of triples")
    @MethodSource("sequences")
    void sequencesBuilding(String numberAsString, int expectedTriplesCount) {
        tripleSequenceFactory.setSource(numberAsString);
        TripleSequence tripleSequence = tripleSequenceFactory.create();
        assertEquals(expectedTriplesCount, tripleSequence.getTriples().size());
    }


}
