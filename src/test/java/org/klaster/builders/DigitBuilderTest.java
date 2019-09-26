package org.klaster.builders;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.models.Digit;
import org.klaster.models.NamedOrder;

import java.util.stream.Stream;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
class DigitBuilderTest {
    static private DigitBuilder digitBuilder;

    @BeforeAll
    static void setUp() {
        digitBuilder = new DigitBuilder();
    }

    @AfterAll
    static void setDown() {
        digitBuilder.reset();
    }

    static Stream<Arguments> digitParams() {
        return Stream.of(
                Arguments.of(NamedOrder.Case.NOMINATIVE, NamedOrder.Form.SINGULAR, 1, "1"),
                Arguments.of(NamedOrder.Case.GENITIVE, NamedOrder.Form.PLURAL, 2, "11"),
                Arguments.of(NamedOrder.Case.NOMINATIVE, NamedOrder.Form.SINGULAR, 0, "12"),
                Arguments.of(NamedOrder.Case.GENITIVE, NamedOrder.Form.PLURAL, 1, "0")
        );
    }

    @ParameterizedTest
    @DisplayName("Builds digits from passed params, except gender forms")
    @MethodSource("digitParams")
    void createDigitByParams(NamedOrder.Case expectedCase, NamedOrder.Form expectedForm, int expectedPositionInTriple
            , String expectedSymbol) {
        Digit digit =
                digitBuilder.withForm(expectedForm)
                            .withPositionInTriple(expectedPositionInTriple)
                            .withCase(expectedCase)
                            .withSymbol(expectedSymbol)
                            .getResult();
        assertEquals(expectedCase, digit.getCase());
        assertEquals(expectedForm, digit.getForm());
        assertEquals(expectedPositionInTriple, digit.getPositionInTriple());
        assertEquals(expectedSymbol, digit.getSymbol());
    }
}