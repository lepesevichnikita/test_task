package org.klaster.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.klaster.factories.DefaultNamedOrdersRepositoryFactory;
import org.klaster.models.NamedOrder;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DefaultNamedOrdersRepositoryTest {
    static NamedOrdersRepository namedOrdersRepository;

    @BeforeAll
    static void init() {
        namedOrdersRepository = new DefaultNamedOrdersRepositoryFactory().loadRepository();
    }

    static Stream<Arguments> namedOrders() {
        return Stream.of(
                Arguments.of(0 , Declension.Gender.MASCULINE, ""),
                Arguments.of(1 , Declension.Gender.FEMININE , "тысяч"),
                Arguments.of(2 , Declension.Gender.MASCULINE, "миллион"),
                Arguments.of(3 , Declension.Gender.MASCULINE, "миллиард"),
                Arguments.of(4 , Declension.Gender.MASCULINE, "триллион"),
                Arguments.of(5 , Declension.Gender.MASCULINE, "квадриллион"),
                Arguments.of(6 , Declension.Gender.MASCULINE, "квинтиллион"),
                Arguments.of(7 , Declension.Gender.MASCULINE, "секстиллион"),
                Arguments.of(8 , Declension.Gender.MASCULINE, "септиллион"),
                Arguments.of(9 , Declension.Gender.MASCULINE, "октиллион"),
                Arguments.of(10, Declension.Gender.MASCULINE, "нониллион"),
                Arguments.of(11, Declension.Gender.MASCULINE, "дециллион"),
                Arguments.of(12, Declension.Gender.MASCULINE, "ундециллион"),
                Arguments.of(13, Declension.Gender.MASCULINE, "додециллион"),
                Arguments.of(14, Declension.Gender.MASCULINE, "тредециллион"),
                Arguments.of(15, Declension.Gender.MASCULINE, "кваттуордециллион"),
                Arguments.of(16, Declension.Gender.MASCULINE, "квиндециллион"),
                Arguments.of(17, Declension.Gender.MASCULINE, "сексдециллион"),
                Arguments.of(18, Declension.Gender.MASCULINE, "септемдециллион"),
                Arguments.of(19, Declension.Gender.MASCULINE, "октодециллион"),
                Arguments.of(20, Declension.Gender.MASCULINE, "новемдециллион"),
                Arguments.of(21, Declension.Gender.MASCULINE, "вигинтиллион"),
                Arguments.of(22, Declension.Gender.MASCULINE, "унвигинтиллион"),
                Arguments.of(23, Declension.Gender.MASCULINE, "дуовигинтиллион"),
                Arguments.of(24, Declension.Gender.MASCULINE, "тревигинтиллион"),
                Arguments.of(25, Declension.Gender.MASCULINE, "кватуорвигинтиллион"),
                Arguments.of(26, Declension.Gender.MASCULINE, "квинвигинтиллион"),
                Arguments.of(27, Declension.Gender.MASCULINE, "сексвигинтиллион"),
                Arguments.of(28, Declension.Gender.MASCULINE, "септенвигинтиллион"),
                Arguments.of(29, Declension.Gender.MASCULINE, "октовигинтиллион"),
                Arguments.of(30, Declension.Gender.MASCULINE, "новемвигинтиллион"),
                Arguments.of(31, Declension.Gender.MASCULINE, "тригинтиллион"),
                Arguments.of(32, Declension.Gender.MASCULINE, "унтригинтиллион"),
                Arguments.of(33, Declension.Gender.MASCULINE, "дуотригинтиллион"),
                Arguments.of(34, Declension.Gender.MASCULINE, "третригинтиллион"),
                Arguments.of(35, Declension.Gender.MASCULINE, "кватортригинтиллион"),
                Arguments.of(36, Declension.Gender.MASCULINE, "квинтригинтиллион"),
                Arguments.of(37, Declension.Gender.MASCULINE, "секстригинтиллион")
        );
    }

    @Test
    @DisplayName("Has 38 named orders")
    void hasThirtyEightRecords() {
        assertEquals(38, namedOrdersRepository.getItems().size());
    }

    @ParameterizedTest
    @DisplayName("Returns NamedOrder by named order number, with default gender, form and case")
    @MethodSource("namedOrders")
    void namedOrdersByNumber(int namedOrderNumber, Declension.Gender expectedGender, String expectedRoot) {
        NamedOrder namedOrder = namedOrdersRepository.getByNumber(namedOrderNumber);
        assertEquals(expectedGender, namedOrder.getGender());
        assertEquals(expectedRoot, namedOrder.getRoot());
    }
}
