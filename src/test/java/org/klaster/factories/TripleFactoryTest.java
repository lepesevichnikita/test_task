package org.klaster.factories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.TripleBuilder;
import org.klaster.models.Triple;
import org.klaster.services.DigitsRepository;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class TripleFactoryTest {
    static private TripleBuilder    tripleBuilder;
    static private TripleFactory    tripleFactory;
    static private DigitsRepository digitsRepository;

    @BeforeAll
    static void init() {
        tripleFactory = new TripleFactory();
        tripleBuilder = new TripleBuilder();

        digitsRepository = DigitsRepository.loadRepository();
        tripleFactory.setTripleBuilder(tripleBuilder);
        tripleFactory.setDigitsRepository(digitsRepository);
    }

    @AfterEach
    void reset() {
        tripleBuilder.reset();
    }

    static Stream<Arguments> triplesOfZeroOrder() {
        return Stream.of(
                Arguments.of("0", 1, "ноль"),
                Arguments.of("10", 1, "десять"),
                Arguments.of("100", 1, "сто"),
                Arguments.of("200", 1, "двести"),
                Arguments.of("000", 0, ""),
                Arguments.of("101", 2, "сто один"),
                Arguments.of("110", 2, "сто десять"),
                Arguments.of("111", 2, "сто одиннадцать"),
                Arguments.of("123", 3, "сто двадцать три"),
                Arguments.of("121", 3, "сто двадцать один")
        );
    }

    @ParameterizedTest
    @DisplayName("Builds tripple with valid count of Digits")
    @MethodSource("triplesOfZeroOrder")
    void buildTriples(String tripleAsString, int expectedDigitsCount, String expectedResult) {
        tripleFactory.setSource(tripleAsString);
        Triple result = tripleFactory.createTriple();
        assertEquals(expectedDigitsCount, result.getDigits().size());
    }
}
