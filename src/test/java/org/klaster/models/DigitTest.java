package org.klaster.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */

public class DigitTest {
    private Digit digit;

    private static Stream<Arguments> digitsWithFeminineAndNeuterFormsUnderTen() {
        return Stream.of(
                Arguments.of("1", 0, "один", "одна", "одно", NamedOrder.Form.SINGULAR, NamedOrder.Case.NOMINATIVE),
                Arguments.of("2", 0, "два", "две", "два", NamedOrder.Form.SINGULAR, NamedOrder.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> digitsWithoutFeminineAndNeuterFormsUnderTen() {
        return Stream.of(
                Arguments.of("0", 0, "ноль", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("3", 0, "три", "", "", NamedOrder.Form.SINGULAR, NamedOrder.Case.GENITIVE),
                Arguments.of("4", 0, "четыре", "", "", NamedOrder.Form.SINGULAR, NamedOrder.Case.GENITIVE),
                Arguments.of("5", 0, "пять", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("6", 0, "шесть", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("7", 0, "семь", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("8", 0, "восемь", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("9", 0, "девять", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> numbersBetweenTenAndTwenty() {
        return Stream.of(
                Arguments.of("10", 1, "десять", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("11", 1, "одиннадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("12", 1, "двенадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("13", 1, "тринадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("14", 1, "четырнадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("15", 1, "пятнадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("16", 1, "шестнадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("17", 1, "семнадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("18", 1, "восемнадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("19", 1, "девятнадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> tens() {
        return Stream.of(
                Arguments.of("2", 1, "двадцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("3", 1, "тридцать", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("4", 1, "сорок", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("5", 1, "пятьдесят", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("6", 1, "шестьдесят", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("7", 1, "семьдесят", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("8", 1, "восемьдесят", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("9", 1, "девяносто", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> hundreds() {
        return Stream.of(
                Arguments.of("1", 2, "сто", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("2", 2, "двести", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("3", 2, "триста", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("4", 2, "четыреста", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("5", 2, "пятьсот", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("6", 2, "шестьсот", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("7", 2, "семьсот", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("8", 2, "восемьсот", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE),
                Arguments.of("9", 2, "девятьсот", "", "", NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE)
        );
    }

    @ParameterizedTest
    @DisplayName("Converts base digits under 10 without feminine and neuter form to its masculine form in different " +
                         "genders")
    @MethodSource({"digitsWithoutFeminineAndNeuterFormsUnderTen", "numbersBetweenTenAndTwenty", "tens", "hundreds" })
    void digitsWithoutFeminineAndNeuterFormsUnderTen(String digit,
                                                     int positionInTriple,
                                                     String masculineForm,
                                                     String feminineForm,
                                                     String neuterForm,
                                                     NamedOrder.Form requiredNamedOrderForm,
                                                     NamedOrder.Case requiredNamedOrderCase) {
        this.digit = new Digit();
        this.digit.setDigit(digit);
        this.digit.setPositionInTriple(positionInTriple);
        this.digit.setForm(NamedOrder.Gender.MASCULINE, masculineForm);
        this.digit.setForm(NamedOrder.Gender.FEMININE, feminineForm);
        this.digit.setForm(NamedOrder.Gender.NEUTER, neuterForm);
        this.digit.setRequiredNamedOrderForm(requiredNamedOrderForm);
        this.digit.setRequiredNamedOrderCase(requiredNamedOrderCase);
        assertEquals(this.digit.toString(), masculineForm);

        this.digit.setCurrentGender(NamedOrder.Gender.FEMININE);
        assertEquals(this.digit.toString(), masculineForm);

        this.digit.setCurrentGender(NamedOrder.Gender.NEUTER);
        assertEquals(this.digit.toString(), masculineForm);
    }

    @ParameterizedTest
    @DisplayName("Converts base digits under 10 with feminine and neuter form to different forms in different genders")
    @MethodSource("digitsWithFeminineAndNeuterFormsUnderTen")
    void digitsWithFeminineAndNeuterForms(String digit,
                                                     int positionInTriple,
                                                     String expectedMasculineForm,
                                                     String expectedFeminineForm,
                                                     String expectedNeuterForm,
                                                     NamedOrder.Form requiredNamedOrderForm,
                                                     NamedOrder.Case requiredNamedOrderCase) {
        this.digit = new Digit();
        this.digit.setDigit(digit);
        this.digit.setPositionInTriple(positionInTriple);
        this.digit.setForm(NamedOrder.Gender.MASCULINE, expectedMasculineForm);
        this.digit.setForm(NamedOrder.Gender.FEMININE, expectedFeminineForm);
        this.digit.setForm(NamedOrder.Gender.NEUTER, expectedNeuterForm);
        this.digit.setRequiredNamedOrderForm(requiredNamedOrderForm);
        this.digit.setRequiredNamedOrderCase(requiredNamedOrderCase);
        assertEquals(this.digit.toString(), expectedMasculineForm);

        this.digit.setCurrentGender(NamedOrder.Gender.FEMININE);
        assertEquals(expectedFeminineForm, this.digit.toString());

        this.digit.setCurrentGender(NamedOrder.Gender.NEUTER);
        assertEquals(expectedNeuterForm, this.digit.toString());
    }
}
