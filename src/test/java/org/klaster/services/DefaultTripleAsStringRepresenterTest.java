package org.klaster.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.DefaultTripleAsStringRepresenterBuilder;
import org.klaster.builders.DefaultTripleFactoryBuilder;
import org.klaster.factories.DefaultNamedOrdersRepositoryFactory;
import org.klaster.interfaces.NamedOrdersRepository;
import org.klaster.interfaces.TripleAsStringRepresenter;
import org.klaster.interfaces.TripleFactory;
import org.klaster.models.Triple;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/27/19
 * @project testtask
 */
public class DefaultTripleAsStringRepresenterTest {
    static private TripleAsStringRepresenter tripleAsStringRepresenter;
    static private TripleFactory             tripleFactory;
    static private NamedOrdersRepository     namedOrdersRepository;

    @BeforeAll
    static void init() {
        namedOrdersRepository = new DefaultNamedOrdersRepositoryFactory().loadRepository();
        initTripleAsWordsRepresenter();
        initTripleFactory();
    }

    static void initTripleAsWordsRepresenter() {
        tripleAsStringRepresenter = new DefaultTripleAsStringRepresenterBuilder().getResult();
    }

    static void initTripleFactory() {
        tripleFactory = new DefaultTripleFactoryBuilder().getResult();
    }

    static Stream<Arguments> triples() {
        return Stream.of(
                Arguments.of("0", 0, "ноль"),
                Arguments.of("00", 0, "ноль"),
                Arguments.of("000", 0, "ноль"),
                Arguments.of("0", 1, ""),
                Arguments.of("00", 1, ""),
                Arguments.of("000", 1, ""),
                Arguments.of("1", 0, "один"),
                Arguments.of("01", 0, "один"),
                Arguments.of("001", 0, "один"),
                Arguments.of("12", 0, "двенадцать"),
                Arguments.of("012", 0, "двенадцать"),
                Arguments.of("123", 0, "сто двадцать три"),
                Arguments.of("122", 0, "сто двадцать два"),
                Arguments.of("123", 1, "сто двадцать три тысячи"),
                Arguments.of("122", 1, "сто двадцать две тысячи"),
                Arguments.of("121", 1, "сто двадцать одна тысяча"),
                Arguments.of("1", 1, "одна тысяча"),
                Arguments.of("01", 1, "одна тысяча"),
                Arguments.of("001", 1, "одна тысяча"),
                Arguments.of("2", 1, "две тысячи"),
                Arguments.of("02", 1, "две тысячи"),
                Arguments.of("002", 1, "две тысячи"),
                Arguments.of("5", 1, "пять тысяч"),
                Arguments.of("05", 1, "пять тысяч"),
                Arguments.of("005", 1, "пять тысяч"),
                Arguments.of("11", 1, "одиннадцать тысяч"),
                Arguments.of("011", 1, "одиннадцать тысяч"),
                Arguments.of("122", 1, "сто двадцать две тысячи"),
                Arguments.of("123", 2, "сто двадцать три миллиона"),
                Arguments.of("121", 2, "сто двадцать один миллион"),
                Arguments.of("12", 2, "двенадцать миллионов"),
                Arguments.of("012", 2, "двенадцать миллионов"),
                Arguments.of("1", 2, "один миллион"),
                Arguments.of("01", 2, "один миллион"),
                Arguments.of("001", 2, "один миллион"),
                Arguments.of("2", 2, "два миллиона"),
                Arguments.of("02", 2, "два миллиона"),
                Arguments.of("002", 2, "два миллиона"),
                Arguments.of("20", 2, "двадцать миллионов"),
                Arguments.of("020", 2, "двадцать миллионов"),
                Arguments.of("123", 2, "сто двадцать три миллиона"),
                Arguments.of("12", 2, "двенадцать миллионов"),
                Arguments.of("012", 2, "двенадцать миллионов")
        );
    }

    @ParameterizedTest
    @DisplayName("Generates correct string representation of triple")
    @MethodSource("triples")
    void stringRepresentationOfTriple(String tripleSource, int orderNumber,
                                      String expectedStringRepresentationOfTriple) {
        tripleFactory.setSource(tripleSource);
        Triple actualTriple = tripleFactory.loadRepository();
        actualTriple.setNamedOrder(namedOrdersRepository.getByNumber(orderNumber));
        assertEquals(expectedStringRepresentationOfTriple,
                     tripleAsStringRepresenter.from(actualTriple));
    }
}
