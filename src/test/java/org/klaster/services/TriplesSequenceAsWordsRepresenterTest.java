package org.klaster.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.DefaultTripleBuilder;
import org.klaster.builders.DefaultTripleSequenceBuilder;
import org.klaster.builders.DigitsGenderFormsBuilder;
import org.klaster.builders.NamedOrdersFormsBuilder;
import org.klaster.factories.DefaultDigitsRepositoryFactory;
import org.klaster.factories.DefaultNamedOrdersRepositoryFactory;
import org.klaster.factories.TripleFactory;
import org.klaster.factories.TripleSequenceFactory;
import org.klaster.interfaces.DigitsRepository;
import org.klaster.interfaces.NamedOrdersRepository;
import org.klaster.interfaces.TripleBuilder;
import org.klaster.interfaces.TripleSequenceBuilder;
import org.klaster.models.TripleSequence;

import java.util.stream.Stream;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/27/19
 * @project testtask
 */
public class TriplesSequenceAsWordsRepresenterTest {
    static private TriplesSequenceAsWordsRepresenter triplesSequenceAsWordsRepresenter;
    static private TripleSequenceFactory             tripleSequenceFactory;

    @BeforeAll
    static void init() {
        initTripleSequenceAsWordsRepresenter();
        initTripleSequenceFactory();
    }

    static void initTripleSequenceAsWordsRepresenter() {
        DigitsGenderFormsBuilder digitsGenderFormsBuilder = new DigitsGenderFormsBuilder();
        NamedOrdersFormsBuilder namedOrdersFormsBuilder = new NamedOrdersFormsBuilder();
        TripleAsWordsRepresenter tripleAsWordsRepresenter = new TripleAsWordsRepresenter();
        triplesSequenceAsWordsRepresenter = new TriplesSequenceAsWordsRepresenter();

        tripleAsWordsRepresenter.setDigitsGenderFormsBuilder(digitsGenderFormsBuilder);
        tripleAsWordsRepresenter.setNamedOrdersFormsBuilder(namedOrdersFormsBuilder);
        triplesSequenceAsWordsRepresenter.setTripleAsWordsRepresenter(tripleAsWordsRepresenter);
    }

    static void initTripleSequenceFactory() {
        DigitsRepository digitsRepository = new DefaultDigitsRepositoryFactory().loadRepository();
        NamedOrdersRepository namedOrdersRepository = new DefaultNamedOrdersRepositoryFactory().loadRepository();
        TripleBuilder tripleBuilder = new DefaultTripleBuilder();
        TripleFactory tripleFactory = new TripleFactory();
        TripleSequenceBuilder tripleSequenceBuilder = new DefaultTripleSequenceBuilder();
        tripleSequenceFactory = new TripleSequenceFactory();

        tripleFactory.setDefaultDigitsRepository(digitsRepository);
        tripleFactory.setDefaultTripleBuilder(tripleBuilder);
        tripleSequenceFactory.setDefaultNamedOrdersRepository(namedOrdersRepository);
        tripleSequenceFactory.setTripleFactory(tripleFactory);
        tripleSequenceFactory.setDefaultTripleSequenceBuilder(tripleSequenceBuilder);
    }

    static Stream<Arguments> tripleSequences() {
        return Stream.of(
                Arguments.of("1", "один"),
                Arguments.of("0", "ноль"),
                Arguments.of("10", "десять"),
                Arguments.of("01", "один"),
                Arguments.of("00", "ноль"),
                Arguments.of("010", "десять"),
                Arguments.of("001", "один"),
                Arguments.of("000", "ноль"),
                Arguments.of("0010", "десять"),
                Arguments.of("0001", "один"),
                Arguments.of("0000", "ноль"),
                Arguments.of("00010", "десять"),
                Arguments.of("100", "сто"),
                Arguments.of("011", "одиннадцать"),
                Arguments.of("021", "двадцать один"),
                Arguments.of("121", "сто двадцать один"),
                Arguments.of("105", "сто пять"),
                Arguments.of("122", "сто двадцать два"),
                Arguments.of("921", "девятьсот двадцать один"),
                Arguments.of("905", "девятьсот пять"),

                Arguments.of("1000", "одна тысяча"),
                Arguments.of("10000", "десять тысяч"),
                Arguments.of("01000", "одна тысяча"),
                Arguments.of("010000", "десять тысяч"),
                Arguments.of("00100000", "сто тысяч"),
                Arguments.of("001001", "одна тысяча один"),
                Arguments.of("0001110", "одна тысяча сто десять"),
                Arguments.of("1001110", "один миллион одна тысяча сто десять"),
                Arguments.of("1101110", "один миллион сто одна тысяча сто десять"),
                Arguments.of("1111110", "один миллион сто одиннадцать тысяч сто десять"),
                Arguments.of("1111111", "один миллион сто одиннадцать тысяч сто одиннадцать"),
                Arguments.of("1102111", "один миллион сто две тысячи сто одиннадцать"),
                Arguments.of("1000111", "один миллион сто одиннадцать"),
                Arguments.of("999001110", "девятьсот девяносто девять миллионов одна тысяча сто десять"),
                Arguments.of("09101110", "девять миллионов сто одна тысяча сто десять")
        );
    }

    @ParameterizedTest
    @DisplayName("Creates valid words representation of TripleSequence")
    @MethodSource("tripleSequences")
    void wordsRepresentationOfTripleSequence(String numberAsStringOfDigits, String expectedWordsRepresentation) {
        tripleSequenceFactory.setSource(numberAsStringOfDigits);
        TripleSequence tripleSequence = tripleSequenceFactory.createTripleSequence();
        triplesSequenceAsWordsRepresenter.setTripleSequence(tripleSequence);
        assertEquals(expectedWordsRepresentation, triplesSequenceAsWordsRepresenter.asString());
    }
}






