package org.klaster.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.factories.DefaultSuffixesRepositoryFactory;
import org.klaster.interfaces.SuffixesRepository;
import org.klaster.models.Declension;
import org.klaster.models.Suffix;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public class DefaultSuffixesRepositoryTest {
    private static SuffixesRepository suffixesRepository;

    private static Stream<Arguments> suffixParams() {
        return Stream.of(
                Arguments.of(new Declension(Declension.Case.NOMINATIVE,
                                            Declension.Form.SINGULAR,
                                            Declension.Gender.MASCULINE), ""),
                Arguments.of(new Declension(Declension.Case.GENITIVE,
                                            Declension.Form.SINGULAR,
                                            Declension.Gender.MASCULINE),
                             "а"),
                Arguments.of(new Declension(Declension.Case.NOMINATIVE,
                                            Declension.Form.PLURAL,
                                            Declension.Gender.MASCULINE), "ы"),
                Arguments.of(new Declension(Declension.Case.GENITIVE,
                                            Declension.Form.PLURAL,
                                            Declension.Gender.MASCULINE), "ов"),
                Arguments.of(new Declension(Declension.Case.NOMINATIVE,
                                            Declension.Form.SINGULAR,
                                            Declension.Gender.FEMININE), "а"),
                Arguments.of(new Declension(Declension.Case.GENITIVE,
                                            Declension.Form.SINGULAR,
                                            Declension.Gender.FEMININE), "и"),
                Arguments.of(new Declension(Declension.Case.NOMINATIVE,
                                            Declension.Form.PLURAL,
                                            Declension.Gender.FEMININE), "и"),
                Arguments.of(new Declension(Declension.Case.GENITIVE,
                                            Declension.Form.PLURAL,
                                            Declension.Gender.FEMININE), "")
        );
    }

    @BeforeAll
    static void init() {
        suffixesRepository = new DefaultSuffixesRepositoryFactory().loadRepository();
    }

    @ParameterizedTest
    @DisplayName("Builds valid suffixes by given params")
    @MethodSource("suffixParams")
    void buildsSuffixes(Declension requiredDeclension,
                        String expectedSuffixValue) {
        Suffix actualSuffix = suffixesRepository.getSuffixByDeclension(requiredDeclension);
        assertEquals(actualSuffix.getValue(), expectedSuffixValue);
    }
}
