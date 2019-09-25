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
public class NamedOrderTest {
    private NamedOrder namedOrder;

    private static Stream<Arguments> firstFiveNamedOrders() {
        return Stream.of(
                Arguments.of(0, "", "", ""),
                Arguments.of(1, "тысяча", "тысячи", "тысяч"),
                Arguments.of(2, "миллион", "миллиона", "миллионов"),
                Arguments.of(3, "миллиард", "миллиарда", "миллиардов"),
                Arguments.of(4, "трилион", "триллиона", "триллионов"),
                Arguments.of(5, "квадриллион", "квадриллиона", "квадриллионов")
        );
    }

    @ParameterizedTest
    @DisplayName("Creates valid named order objects with default form and case")
    @MethodSource("firstFiveNamedOrders")
    void namedOrders(int namedOrderNumber, String singularNominativeExpected, String singularGenetiveExpected, String pluralGenetiveExpected) {
        namedOrder = new NamedOrder();
        namedOrder.setNamedOrderNumber(namedOrderNumber);
        namedOrder.setSingular(NamedOrder.Case.NOMINATIVE, singularNominativeExpected);
        namedOrder.setSingular(NamedOrder.Case.GENITIVE, singularGenetiveExpected);
        namedOrder.setPlural(NamedOrder.Case.GENITIVE, pluralGenetiveExpected);
        assertEquals(singularNominativeExpected, namedOrder.getSingular(NamedOrder.Case.NOMINATIVE));
        assertEquals(singularGenetiveExpected, namedOrder.getSingular(NamedOrder.Case.GENITIVE));
        assertEquals(pluralGenetiveExpected, namedOrder.getPlural(NamedOrder.Case.GENITIVE));
        assertEquals(singularNominativeExpected, namedOrder.toString());
    }

    @ParameterizedTest
    @DisplayName("Creates valid named order objects with default form and genetive case")
    @MethodSource("firstFiveNamedOrders")
    void namedOrdersInGenetvieCase(int namedOrderNumber, String singularNominativeExpected, String singularGenetiveExpected, String pluralGenetiveExpected) {
        namedOrder = new NamedOrder();
        namedOrder.setNamedOrderNumber(namedOrderNumber);
        namedOrder.setSingular(NamedOrder.Case.NOMINATIVE, singularNominativeExpected);
        namedOrder.setSingular(NamedOrder.Case.GENITIVE, singularGenetiveExpected);
        namedOrder.setPlural(NamedOrder.Case.GENITIVE, pluralGenetiveExpected);
        namedOrder.setCurrentCase(NamedOrder.Case.GENITIVE);
        assertEquals(singularNominativeExpected, namedOrder.getSingular(NamedOrder.Case.NOMINATIVE));
        assertEquals(singularGenetiveExpected, namedOrder.getSingular(NamedOrder.Case.GENITIVE));
        assertEquals(pluralGenetiveExpected, namedOrder.getPlural(NamedOrder.Case.GENITIVE));
        assertEquals(singularGenetiveExpected, namedOrder.toString());
    }


    @ParameterizedTest
    @DisplayName("Creates valid named order objects with singular form and genetive case")
    @MethodSource("firstFiveNamedOrders")
    void pluralNamedOrdersInGenitiveCase(int namedOrderNumber, String singularNominativeExpected, String singularGenetiveExpected, String pluralGenetiveExpected) {
        namedOrder = new NamedOrder();
        namedOrder.setNamedOrderNumber(namedOrderNumber);
        namedOrder.setSingular(NamedOrder.Case.NOMINATIVE, singularNominativeExpected);
        namedOrder.setSingular(NamedOrder.Case.GENITIVE, singularGenetiveExpected);
        namedOrder.setPlural(NamedOrder.Case.GENITIVE, pluralGenetiveExpected);
        namedOrder.setCurrentForm(NamedOrder.Form.PLURAL);
        namedOrder.setCurrentCase(NamedOrder.Case.GENITIVE);
        assertEquals(singularNominativeExpected, namedOrder.getSingular(NamedOrder.Case.NOMINATIVE));
        assertEquals(singularGenetiveExpected, namedOrder.getSingular(NamedOrder.Case.GENITIVE));
        assertEquals(pluralGenetiveExpected, namedOrder.getPlural(NamedOrder.Case.GENITIVE));
        assertEquals(pluralGenetiveExpected, namedOrder.toString());
    }
}
