package org.klaster.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.DefaultDigitBuilder;

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
                Arguments.of("1", 0, "один", "одна", Declension.Form.SINGULAR, Declension.Case.NOMINATIVE),
                Arguments.of("2", 0, "два", "две", Declension.Form.SINGULAR, Declension.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> digitsWithoutFeminineAndNeuterFormsUnderTen() {
        return Stream.of(
                Arguments.of("0", 0, "ноль", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("3", 0, "три", "", Declension.Form.SINGULAR, Declension.Case.GENITIVE),
                Arguments.of("4", 0, "четыре", "", Declension.Form.SINGULAR, Declension.Case.GENITIVE),
                Arguments.of("5", 0, "пять", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("6", 0, "шесть", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("7", 0, "семь", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("8", 0, "восемь", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("9", 0, "девять", "", Declension.Form.PLURAL, Declension.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> numbersBetweenTenAndTwenty() {
        return Stream.of(
                Arguments.of("10", 1, "десять", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("11", 1, "одиннадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("13", 1, "тринадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("14", 1, "четырнадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("15", 1, "пятнадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("16", 1, "шестнадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("17", 1, "семнадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("18", 1, "восемнадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("19", 1, "девятнадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> tens() {
        return Stream.of(
                Arguments.of("2", 1, "двадцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("3", 1, "тридцать", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("4", 1, "сорок", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("5", 1, "пятьдесят", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("6", 1, "шестьдесят", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("7", 1, "семьдесят", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("8", 1, "восемьдесят", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("9", 1, "девяносто", "", Declension.Form.PLURAL, Declension.Case.GENITIVE)
        );
    }

    private static Stream<Arguments> hundreds() {
        return Stream.of(
                Arguments.of("1", 2, "сто", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("2", 2, "двести", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("3", 2, "триста", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("4", 2, "четыреста", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("5", 2, "пятьсот", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("6", 2, "шестьсот", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("7", 2, "семьсот", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("8", 2, "восемьсот", "", Declension.Form.PLURAL, Declension.Case.GENITIVE),
                Arguments.of("9", 2, "девятьсот", "", Declension.Form.PLURAL, Declension.Case.GENITIVE)
        );
    }

    @BeforeEach
    void init() {
        digit = new DefaultDigitBuilder().getResult();
    }

    @ParameterizedTest
    @DisplayName("Converts base digits under 10 without feminine and neuter form to its masculine form in different " +
                         "genders")
    @MethodSource({
                          "digitsWithFeminineAndNeuterFormsUnderTen",
                          "digitsWithoutFeminineAndNeuterFormsUnderTen",
                          "hundreds",
                          "numbersBetweenTenAndTwenty",
                          "tens"
                  })
    void digitsWithoutFeminineAndNeuterFormsUnderTen(String symbol,
                                                     int positionInTriple,
                                                     String masculineForm,
                                                     String feminineForm,
                                                     Declension.Form requiredNamedOrderForm,
                                                     Declension.Case requiredNamedOrderCase) {
        digit.setSymbol(symbol);
        digit.setPositionInTriple(positionInTriple);
        digit.setGenderForm(Declension.Gender.MASCULINE, masculineForm);
        digit.setGenderForm(Declension.Gender.FEMININE, feminineForm);
        digit.setForm(requiredNamedOrderForm);
        digit.setCase(requiredNamedOrderCase);

        assertEquals(masculineForm, digit.getGenderForm(Declension.Gender.MASCULINE));
        assertEquals(feminineForm, digit.getGenderForm(Declension.Gender.FEMININE));
    }

}
