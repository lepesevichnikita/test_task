package org.klaster.builders;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.models.NamedOrder;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */

public class NamedOrdersFormsBuilderTest {
    private static NamedOrdersFormsBuilder namedOrdersFormsBuilder;

    private static Stream<Arguments> namedOrders() {
        return Stream.of(
                Arguments.of(2, "миллион", NamedOrder.Gender.MASCULINE, "миллион", "миллиона", "миллионы", "миллионов"),
                Arguments.of(1, "тысяч", NamedOrder.Gender.FEMININE, "тысяча", "тысячи", "тысячи", "тысяч"),
                Arguments.of(0, "", NamedOrder.Gender.MASCULINE, "", "", "", "")
        );
    }

    @BeforeAll
    static void init() {
        namedOrdersFormsBuilder = new NamedOrdersFormsBuilder();
    }

    @AfterEach
    void reset() {
        namedOrdersFormsBuilder.reset();
    }

    @ParameterizedTest
    @DisplayName("Builds correct forms of named order, considering it gender")
    @MethodSource("namedOrders")
    void buildsNamedOrdersForms(int namedOrderNumber, String root, NamedOrder.Gender gender,
                                String expectedSingularNominative, String expectedSingularGenitive,
                                String expectedPluralNominative,
                                String expectedPluralGenitive) {
        NamedOrder namedOrder = new NamedOrder();
        namedOrder.setNamedOrderNumber(namedOrderNumber);
        namedOrder.setRoot(root);
        namedOrder.setGender(gender);

        namedOrdersFormsBuilder.withNamedOrder(namedOrder);
        assertEquals(expectedSingularNominative, namedOrdersFormsBuilder.getResult());

        namedOrdersFormsBuilder.withCase(NamedOrder.Case.GENITIVE);
        assertEquals(expectedSingularGenitive, namedOrdersFormsBuilder.getResult());

        namedOrdersFormsBuilder.withForm(NamedOrder.Form.PLURAL).withCase(NamedOrder.Case.NOMINATIVE);
        assertEquals(expectedPluralNominative, namedOrdersFormsBuilder.getResult());

        namedOrdersFormsBuilder.withCase(NamedOrder.Case.GENITIVE);
        assertEquals(expectedPluralGenitive, namedOrdersFormsBuilder.getResult());
    }
}
