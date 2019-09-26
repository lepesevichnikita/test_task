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

public class NamedOrdersSuffixesBuilderTest {
    private static NamedOrdersSuffixesBuilder namedOrdersSuffixesBuilder;

    private static Stream<Arguments> suffixParams() {
        return Stream.of(
                Arguments.of(NamedOrder.Gender.MASCULINE, NamedOrder.Form.SINGULAR, NamedOrder.Case.NOMINATIVE, ""),
                Arguments.of(NamedOrder.Gender.MASCULINE, NamedOrder.Form.SINGULAR, NamedOrder.Case.GENITIVE, "а"),
                Arguments.of(NamedOrder.Gender.MASCULINE, NamedOrder.Form.PLURAL, NamedOrder.Case.NOMINATIVE, "ы"),
                Arguments.of(NamedOrder.Gender.MASCULINE, NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE, "ов"),
                Arguments.of(NamedOrder.Gender.FEMININE, NamedOrder.Form.SINGULAR, NamedOrder.Case.NOMINATIVE, "а"),
                Arguments.of(NamedOrder.Gender.FEMININE, NamedOrder.Form.SINGULAR, NamedOrder.Case.GENITIVE, "и"),
                Arguments.of(NamedOrder.Gender.FEMININE, NamedOrder.Form.PLURAL, NamedOrder.Case.NOMINATIVE, "и"),
                Arguments.of(NamedOrder.Gender.FEMININE, NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE, "")
        );
    }

    @BeforeAll
    static void init() {
        namedOrdersSuffixesBuilder = new NamedOrdersSuffixesBuilder();
    }

    @AfterEach
    void reset() {
        namedOrdersSuffixesBuilder.reset();
    }

    @ParameterizedTest
    @DisplayName("Builds valid suffixes by given params")
    @MethodSource("suffixParams")
    void buildsSuffixes(NamedOrder.Gender requiredGender, NamedOrder.Form requiredForm, NamedOrder.Case requiredCase,
                        String expectedSuffixValue) {
        namedOrdersSuffixesBuilder.withGender(requiredGender).withForm(requiredForm).withCase(requiredCase);
        assertEquals(expectedSuffixValue, namedOrdersSuffixesBuilder.getResult());
    }

}
