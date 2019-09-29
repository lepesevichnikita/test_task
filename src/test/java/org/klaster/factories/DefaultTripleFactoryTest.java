package org.klaster.factories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.DefaultTripleBuilder;
import org.klaster.interfaces.DigitsRepository;
import org.klaster.interfaces.TripleBuilder;
import org.klaster.interfaces.TripleFactory;
import org.klaster.models.Triple;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DefaultTripleFactoryTest {
    static private TripleFactory tripleFactory;

    @BeforeAll
    static void init() {
        initTripleFactory();
    }

    static void initTripleFactory() {
        tripleFactory = new DefaultTripleFactory();
        TripleBuilder tripleBuilder = new DefaultTripleBuilder();
        DigitsRepository digitsRepository = new DefaultDigitsRepositoryFactory().loadRepository();

        tripleFactory.setTripleBuilder(tripleBuilder);
        tripleFactory.setDigitsRepository(digitsRepository);
    }

    static Stream<Arguments> triplesOfZeroOrder() {
        return Stream.of(
                Arguments.of("0", 1),
                Arguments.of("00", 1),
                Arguments.of("10", 1),
                Arguments.of("100", 1),
                Arguments.of("200", 1),
                Arguments.of("000", 1),
                Arguments.of("101", 2),
                Arguments.of("110", 2),
                Arguments.of("111", 2),
                Arguments.of("123", 3),
                Arguments.of("121", 3)
        );
    }

    @ParameterizedTest
    @DisplayName("Builds triple with valid count of Digits")
    @MethodSource("triplesOfZeroOrder")
    void buildTriples(String tripleAsString, int expectedDigitsCount) {
        tripleFactory.setSource(tripleAsString);
        Triple result = tripleFactory.loadRepository();
        assertEquals(expectedDigitsCount, result.getDigits().size());
    }
}
