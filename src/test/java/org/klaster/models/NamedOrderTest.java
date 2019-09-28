package org.klaster.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class NamedOrderTest {
    private NamedOrder namedOrder;

    private static Stream<Arguments> firstTwoOrders() {

        return Stream.of(
                Arguments.of(0, "", "", "", "", "", Declension.Gender.MASCULINE),
                Arguments.of(1, "тысяч", "тысяча", "тысячи", "тысячи", "тысяч", Declension.Gender.FEMININE)
        );
    }

    private static Stream<Arguments> namedOrdersFromTwoToFive() {
        return Stream.of(
                Arguments.of(2, "миллион", "", "", "", ""),
                Arguments.of(3, "миллиард", "", "", "", ""),
                Arguments.of(4, "трилион", "", "", "", ""),
                Arguments.of(5, "квадриллион", "", "", "", "")
        );
    }

    @BeforeEach
    void init() {
        namedOrder = new NamedOrder();
    }

    @ParameterizedTest
    @DisplayName("Creates valid named order, that have order number greater than 2 and default gender")
    @MethodSource("namedOrdersFromTwoToFive")
    void namedOrders(int namedOrderNumber, String root, String expectedSingularNominative,
                     String expectedSingularGenitive,
                     String expectedPluralNominative, String expectedPluralGenitive) {
        namedOrder.setRoot(root);
        namedOrder.setNumber(namedOrderNumber);
        namedOrder.setSingular(Declension.Case.NOMINATIVE, expectedSingularNominative);
        namedOrder.setSingular(Declension.Case.GENITIVE, expectedSingularGenitive);
        namedOrder.setPlural(Declension.Case.NOMINATIVE, expectedPluralNominative);
        namedOrder.setPlural(Declension.Case.GENITIVE, expectedPluralGenitive);

        assertEquals(Declension.Gender.MASCULINE, namedOrder.getGender());
        assertEquals(expectedSingularNominative, namedOrder.getSingular(Declension.Case.NOMINATIVE));
        assertEquals(expectedSingularGenitive, namedOrder.getSingular(Declension.Case.GENITIVE));
        assertEquals(expectedPluralNominative, namedOrder.getPlural(Declension.Case.NOMINATIVE));
        assertEquals(expectedPluralGenitive, namedOrder.getPlural(Declension.Case.GENITIVE));
    }

    @ParameterizedTest
    @DisplayName("Creates valid named orders. that have order number less or equal than 2 and non-masculine gender")
    @MethodSource("firstTwoOrders")
    void namedOrders(int expectedNumber, String root, String expectedSingularNominative,
                     String expectedSingularGenitive,
                     String expectedPluralNominative, String expectedPluralGenitive, Declension.Gender expectedGender) {
        namedOrder.setRoot(root);
        namedOrder.setNumber(expectedNumber);
        namedOrder.setSingular(Declension.Case.NOMINATIVE, expectedSingularNominative);
        namedOrder.setSingular(Declension.Case.GENITIVE, expectedSingularGenitive);
        namedOrder.setPlural(Declension.Case.NOMINATIVE, expectedPluralNominative);
        namedOrder.setPlural(Declension.Case.GENITIVE, expectedPluralGenitive);
        namedOrder.setGender(expectedGender);

        assertEquals(expectedGender, namedOrder.getGender());
        assertEquals(expectedSingularNominative, namedOrder.getSingular(Declension.Case.NOMINATIVE));
        assertEquals(expectedSingularGenitive, namedOrder.getSingular(Declension.Case.GENITIVE));
        assertEquals(expectedPluralNominative, namedOrder.getPlural(Declension.Case.NOMINATIVE));
        assertEquals(expectedPluralGenitive, namedOrder.getPlural(Declension.Case.GENITIVE));
    }
}
