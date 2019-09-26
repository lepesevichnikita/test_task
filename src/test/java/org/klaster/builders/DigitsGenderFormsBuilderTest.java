package org.klaster.builders;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.models.Digit;
import org.klaster.models.NamedOrder;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DigitsGenderFormsBuilderTest {
    static DigitsGenderFormsBuilder digitsGenderFormsBuilder;
    Digit digit;

    @BeforeEach
    private void initPrivate() {
        digit = new Digit();
    }

    @BeforeAll
    static void init() {
        digitsGenderFormsBuilder = new DigitsGenderFormsBuilder();
    }

    private static Stream<Arguments> digitsUnderTwo() {
        return Stream.of(
                Arguments.of("1", 0, "один", "одна"),
                Arguments.of("2", 0, "два", "две")
        );
    }

    private static Stream<Arguments> digitsBetweenThreeAndTen() {
        return Stream.of(
                Arguments.of("0", 0, "ноль", ""),
                Arguments.of("3", 0, "три", ""),
                Arguments.of("4", 0, "четыре", ""),
                Arguments.of("5", 0, "пять", ""),
                Arguments.of("6", 0, "шесть", ""),
                Arguments.of("7", 0, "семь", ""),
                Arguments.of("8", 0, "восемь", ""),
                Arguments.of("9", 0, "девять", "")
        );
    }

    private static Stream<Arguments> numbersBetweenTenAndTwenty() {
        return Stream.of(
                Arguments.of("10", 1, "десять", ""),
                Arguments.of("11", 1, "одиннадцать", ""),
                Arguments.of("13", 1, "тринадцать", ""),
                Arguments.of("14", 1, "четырнадцать", ""),
                Arguments.of("15", 1, "пятнадцать", ""),
                Arguments.of("16", 1, "шестнадцать", ""),
                Arguments.of("17", 1, "семнадцать", ""),
                Arguments.of("18", 1, "восемнадцать", ""),
                Arguments.of("19", 1, "девятнадцать", "")
        );
    }

    private static Stream<Arguments> tens() {
        return Stream.of(
                Arguments.of("2", 1, "двадцать", ""),
                Arguments.of("3", 1, "тридцать", ""),
                Arguments.of("4", 1, "сорок", ""),
                Arguments.of("5", 1, "пятьдесят", ""),
                Arguments.of("6", 1, "шестьдесят", ""),
                Arguments.of("7", 1, "семьдесят", ""),
                Arguments.of("8", 1, "восемьдесят", ""),
                Arguments.of("9", 1, "девяносто", "")
        );
    }

    private static Stream<Arguments> hundreds() {
        return Stream.of(
                Arguments.of("1", 2, "сто", ""),
                Arguments.of("2", 2, "двести", ""),
                Arguments.of("3", 2, "триста", ""),
                Arguments.of("4", 2, "четыреста", ""),
                Arguments.of("5", 2, "пятьсот", ""),
                Arguments.of("6", 2, "шестьсот", ""),
                Arguments.of("7", 2, "семьсот", ""),
                Arguments.of("8", 2, "восемьсот", ""),
                Arguments.of("9", 2, "девятьсот", "")
        );
    }

    @AfterEach
    void reset() {
        digitsGenderFormsBuilder.reset();
    }

    @ParameterizedTest
    @DisplayName("Builds correct forms of digits, that haven't feminine gender")
    @MethodSource({"digitsBetweenThreeAndTen", "numbersBetweenTenAndTwenty", "tens", "hundreds"})
    void buildsGenderFormsOfDigitsWithoutFeminineForm(String digitSymbol, int positionInTriple,
                                                      String expectedMasculineForm,
                                                      String expectedFeminineForm) {
        digit.setSymbol(digitSymbol);
        digit.setPositionInTriple(positionInTriple);
        digit.setGenderForm(NamedOrder.Gender.MASCULINE, expectedMasculineForm);
        digit.setGenderForm(NamedOrder.Gender.FEMININE, expectedFeminineForm);

        digitsGenderFormsBuilder.withDigit(digit);
        assertEquals(expectedMasculineForm, digitsGenderFormsBuilder.getResult());

        digitsGenderFormsBuilder.withGender(NamedOrder.Gender.FEMININE);
        assertEquals(expectedMasculineForm, digitsGenderFormsBuilder.getResult());
    }

    @ParameterizedTest
    @DisplayName("Builds correct forms of digits with feminine gender")
    @MethodSource("digitsUnderTwo")
    void buildsGenderFormsOfDigitsWithFeminineForm(String digitSymbol, int positionInTriple,
                                                   String expectedMasculineForm,
                                                      String expectedFeminineForm) {
        digit.setSymbol(digitSymbol);
        digit.setPositionInTriple(positionInTriple);
        digit.setGenderForm(NamedOrder.Gender.MASCULINE, expectedMasculineForm);
        digit.setGenderForm(NamedOrder.Gender.FEMININE, expectedFeminineForm);

        digitsGenderFormsBuilder.withDigit(digit);
        assertEquals(expectedMasculineForm, digitsGenderFormsBuilder.getResult());

        digitsGenderFormsBuilder.withGender(NamedOrder.Gender.FEMININE);
        assertEquals(expectedFeminineForm, digitsGenderFormsBuilder.getResult());
    }
}
