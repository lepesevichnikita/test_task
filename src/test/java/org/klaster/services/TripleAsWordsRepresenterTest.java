package org.klaster.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.DigitsGenderFormsBuilder;
import org.klaster.builders.NamedOrdersFormsBuilder;
import org.klaster.builders.TripleBuilder;
import org.klaster.factories.TripleFactory;
import org.klaster.models.NamedOrder;
import org.klaster.models.Triple;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/27/19
 * @project testtask
 */
public class TripleAsWordsRepresenterTest {
    static private DigitsGenderFormsBuilder digitsGenderFormsBuilder;
    static private NamedOrdersFormsBuilder  namedOrdersFormsBuilder;
    static private NamedOrdersRepository    namedOrdersRepository;
    static private TripleAsWordsRepresenter tripleAsWordsRepresenter;
    static private TripleBuilder            tripleBuilder;
    static private TripleFactory            tripleFactory;
    static private DigitsRepository         digitsRepository;

    @BeforeAll
    static void init() {
        digitsGenderFormsBuilder = new DigitsGenderFormsBuilder();
        digitsRepository         = DigitsRepository.loadRepository();
        namedOrdersFormsBuilder  = new NamedOrdersFormsBuilder();
        namedOrdersRepository    = NamedOrdersRepository.loadRepository();
        tripleAsWordsRepresenter = new TripleAsWordsRepresenter();
        tripleBuilder            = new TripleBuilder();
        tripleFactory            = new TripleFactory();

        tripleFactory.setTripleBuilder(tripleBuilder);
        tripleFactory.setDigitsRepository(digitsRepository);
        tripleAsWordsRepresenter.setDigitsGenderFormsBuilder(digitsGenderFormsBuilder);
        tripleAsWordsRepresenter.setNamedOrdersFormsBuilder(namedOrdersFormsBuilder);
    }

    static Stream<Arguments> triples() {
        return Stream.of(
                Arguments.of("1", namedOrdersRepository.getByNamedOrderNumber(0), "один"),
                Arguments.of("01", namedOrdersRepository.getByNamedOrderNumber(0), "один"),
                Arguments.of("001", namedOrdersRepository.getByNamedOrderNumber(0), "один"),
                Arguments.of("12", namedOrdersRepository.getByNamedOrderNumber(0), "двенадцать"),
                Arguments.of("012", namedOrdersRepository.getByNamedOrderNumber(0), "двенадцать"),
                Arguments.of("123", namedOrdersRepository.getByNamedOrderNumber(0), "сто двадцать три"),
                Arguments.of("122", namedOrdersRepository.getByNamedOrderNumber(0), "сто двадцать два"),
                Arguments.of("123", namedOrdersRepository.getByNamedOrderNumber(1), "сто двадцать три тысячи"),
                Arguments.of("122", namedOrdersRepository.getByNamedOrderNumber(1), "сто двадцать две тысячи"),
                Arguments.of("121", namedOrdersRepository.getByNamedOrderNumber(1), "сто двадцать одна тысяча"),
                Arguments.of("1", namedOrdersRepository.getByNamedOrderNumber(1), "одна тысяча"),
                Arguments.of("01", namedOrdersRepository.getByNamedOrderNumber(1), "одна тысяча"),
                Arguments.of("001", namedOrdersRepository.getByNamedOrderNumber(1), "одна тысяча"),
                Arguments.of("2", namedOrdersRepository.getByNamedOrderNumber(1), "две тысячи"),
                Arguments.of("02", namedOrdersRepository.getByNamedOrderNumber(1), "две тысячи"),
                Arguments.of("002", namedOrdersRepository.getByNamedOrderNumber(1), "две тысячи"),
                Arguments.of("5", namedOrdersRepository.getByNamedOrderNumber(1), "пять тысяч"),
                Arguments.of("05", namedOrdersRepository.getByNamedOrderNumber(1), "пять тысяч"),
                Arguments.of("005", namedOrdersRepository.getByNamedOrderNumber(1), "пять тысяч"),
                Arguments.of("11", namedOrdersRepository.getByNamedOrderNumber(1), "одиннадцать тысяч"),
                Arguments.of("011", namedOrdersRepository.getByNamedOrderNumber(1), "одиннадцать тысяч"),
                Arguments.of("122", namedOrdersRepository.getByNamedOrderNumber(1), "сто двадцать две тысячи"),
                Arguments.of("123", namedOrdersRepository.getByNamedOrderNumber(2), "сто двадцать три миллиона"),
                Arguments.of("121", namedOrdersRepository.getByNamedOrderNumber(2), "сто двадцать один миллион"),
                Arguments.of("12", namedOrdersRepository.getByNamedOrderNumber(2), "двенадцать миллионов"),
                Arguments.of("012", namedOrdersRepository.getByNamedOrderNumber(2), "двенадцать миллионов"),
                Arguments.of("1", namedOrdersRepository.getByNamedOrderNumber(2), "один миллион"),
                Arguments.of("01", namedOrdersRepository.getByNamedOrderNumber(2), "один миллион"),
                Arguments.of("001", namedOrdersRepository.getByNamedOrderNumber(2), "один миллион"),
                Arguments.of("2", namedOrdersRepository.getByNamedOrderNumber(2), "два миллиона"),
                Arguments.of("02", namedOrdersRepository.getByNamedOrderNumber(2), "два миллиона"),
                Arguments.of("002", namedOrdersRepository.getByNamedOrderNumber(2), "два миллиона"),
                Arguments.of("20", namedOrdersRepository.getByNamedOrderNumber(2), "двадцать миллионов"),
                Arguments.of("020", namedOrdersRepository.getByNamedOrderNumber(2), "двадцать миллионов"),
                Arguments.of("123", namedOrdersRepository.getByNamedOrderNumber(2), "сто двадцать три миллиона"),
                Arguments.of("12", namedOrdersRepository.getByNamedOrderNumber(2), "двенадцать миллионов"),
                Arguments.of("012", namedOrdersRepository.getByNamedOrderNumber(2), "двенадцать миллионов")
        );
    }

    @ParameterizedTest
    @DisplayName("Generates correct string representation of triple")
    @MethodSource("triples")
    void stringRepresentationOfTriple(String tripleSource, NamedOrder namedOrder,
                                      String expectedStringRepresentationOfTriple) {
        tripleFactory.setSource(tripleSource);
        Triple actualTriple = tripleFactory.createTriple();
        actualTriple.setNamedOrder(namedOrder);
        tripleAsWordsRepresenter.setTriple(actualTriple);
        assertEquals(expectedStringRepresentationOfTriple, tripleAsWordsRepresenter.asString());
    }
}
