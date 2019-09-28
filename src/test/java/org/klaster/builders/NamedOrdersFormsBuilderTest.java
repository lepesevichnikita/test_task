package org.klaster.builders;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.models.Declension;
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
                Arguments.of(2, "миллион", Declension.Gender.MASCULINE, "миллион", "миллиона", "миллионы", "миллионов"),
                Arguments.of(1, "тысяч", Declension.Gender.FEMININE, "тысяча", "тысячи", "тысячи", "тысяч"),
                Arguments.of(0, "", Declension.Gender.MASCULINE, "", "", "", "")
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
    void buildsNamedOrdersForms(int namedOrderNumber, String root, Declension.Gender gender,
                                String expectedSingularNominative, String expectedSingularGenitive,
                                String expectedPluralNominative,
                                String expectedPluralGenitive) {
        NamedOrder namedOrder = new NamedOrder();
        namedOrder.setNumber(namedOrderNumber);
        namedOrder.setRoot(root);
        namedOrder.setGender(gender);

        namedOrdersFormsBuilder.withNamedOrder(namedOrder);
        assertEquals(expectedSingularNominative, namedOrdersFormsBuilder.getResult());

        namedOrdersFormsBuilder.withCase(Declension.Case.GENITIVE);
        assertEquals(expectedSingularGenitive, namedOrdersFormsBuilder.getResult());

        namedOrdersFormsBuilder.withForm(Declension.Form.PLURAL).withCase(Declension.Case.NOMINATIVE);
        assertEquals(expectedPluralNominative, namedOrdersFormsBuilder.getResult());

        namedOrdersFormsBuilder.withCase(Declension.Case.GENITIVE);
        assertEquals(expectedPluralGenitive, namedOrdersFormsBuilder.getResult());
    }
}
