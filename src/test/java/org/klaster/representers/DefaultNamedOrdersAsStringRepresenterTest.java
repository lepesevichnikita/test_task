package org.klaster.representers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.builders.DefaultNamedOrdersAsStringRepresenterBuilder;
import org.klaster.interfaces.NamedOrdersAsStringRepresenter;
import org.klaster.models.Declension;
import org.klaster.models.NamedOrder;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */

public class DefaultNamedOrdersAsStringRepresenterTest {
    private static NamedOrdersAsStringRepresenter namedOrdersAsStringRepresenter;

    private static Stream<Arguments> namedOrders() {
        return Stream.of(
                Arguments.of(2, "миллион", Declension.Gender.MASCULINE, "миллион", "миллиона", "миллионы", "миллионов"),
                Arguments.of(1, "тысяч", Declension.Gender.FEMININE, "тысяча", "тысячи", "тысячи", "тысяч"),
                Arguments.of(0, "", Declension.Gender.MASCULINE, "", "", "", "")
        );
    }

    @BeforeAll
    static void init() {
        namedOrdersAsStringRepresenter = new DefaultNamedOrdersAsStringRepresenterBuilder().getResult();
    }

    @AfterEach
    void reset() {
        namedOrdersAsStringRepresenter.reset();
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

        assertEquals(expectedSingularNominative, namedOrdersAsStringRepresenter.from(namedOrder));

        assertEquals(expectedSingularGenitive,
                     namedOrdersAsStringRepresenter.withCase(Declension.Case.GENITIVE).from(namedOrder));
        assertEquals(expectedPluralNominative,
                     namedOrdersAsStringRepresenter.withForm(Declension.Form.PLURAL)
                                                   .withCase(Declension.Case.NOMINATIVE)
                                                   .from(namedOrder));

        assertEquals(expectedPluralGenitive,
                     namedOrdersAsStringRepresenter.withCase(Declension.Case.GENITIVE).from(namedOrder));
    }
}
