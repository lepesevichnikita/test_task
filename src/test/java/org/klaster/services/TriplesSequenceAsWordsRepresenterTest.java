package org.klaster.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.*;
import org.klaster.factories.TripleSequenceFactory;
import org.klaster.models.TripleSequence;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/27/19
 * @project testtask
 */
public class TriplesSequenceAsWordsRepresenterTest {
    static private TriplesSequenceAsWordsRepresenter tripleSequenceAsWordsRepresenter;
    static private TripleSequenceFactory             tripleSequenceFactory;

    @BeforeAll
    static void init() {
        initTripleSequenceAsWordsRepresenter();
        initTripleSequenceFactory();
    }

    static void initTripleSequenceAsWordsRepresenter() {
        tripleSequenceAsWordsRepresenter = new DefaultTripleSequenceAsWordsRepresenterBuilder().getResult();
    }

    static void initTripleSequenceFactory() {
        tripleSequenceFactory = new DefaultTripleSequenceFactoryBuilder().getResult();
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
        tripleSequenceAsWordsRepresenter.setTripleSequence(tripleSequence);
        assertEquals(expectedWordsRepresentation, tripleSequenceAsWordsRepresenter.asString());
    }
}






