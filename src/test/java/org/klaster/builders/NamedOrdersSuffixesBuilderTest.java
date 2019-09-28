package org.klaster.builders;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.models.Declension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamedOrdersSuffixesBuilderTest {
    private static NamedOrdersSuffixesBuilder namedOrdersSuffixesBuilder;

    private static Stream<Arguments> suffixParams() {
        return Stream.of(
                Arguments.of(Declension.Gender.MASCULINE, Declension.Form.SINGULAR, Declension.Case.NOMINATIVE, ""),
                Arguments.of(Declension.Gender.MASCULINE, Declension.Form.SINGULAR, Declension.Case.GENITIVE, "а"),
                Arguments.of(Declension.Gender.MASCULINE, Declension.Form.PLURAL, Declension.Case.NOMINATIVE, "ы"),
                Arguments.of(Declension.Gender.MASCULINE, Declension.Form.PLURAL, Declension.Case.GENITIVE, "ов"),
                Arguments.of(Declension.Gender.FEMININE, Declension.Form.SINGULAR, Declension.Case.NOMINATIVE, "а"),
                Arguments.of(Declension.Gender.FEMININE, Declension.Form.SINGULAR, Declension.Case.GENITIVE, "и"),
                Arguments.of(Declension.Gender.FEMININE, Declension.Form.PLURAL, Declension.Case.NOMINATIVE, "и"),
                Arguments.of(Declension.Gender.FEMININE, Declension.Form.PLURAL, Declension.Case.GENITIVE, "")
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
    void buildsSuffixes(Declension.Gender requiredGender, Declension.Form requiredForm, Declension.Case requiredCase,
                        String expectedSuffixValue) {
        namedOrdersSuffixesBuilder.withGender(requiredGender).withForm(requiredForm).withCase(requiredCase);
        assertEquals(expectedSuffixValue, namedOrdersSuffixesBuilder.getResult());
    }

}
