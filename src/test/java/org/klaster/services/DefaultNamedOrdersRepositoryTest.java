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
public class NamedOrdersRepositoryTest {
    static NamedOrdersRepository namedOrdersRepository;

    @BeforeAll
    static void init() {
        namedOrdersRepository = new DefaultNamedOrdersRepositoryFactory().loadRepository();
    }

    static Stream<Arguments> namedOrders() {
        return Stream.of(
                Arguments.of(0 , NamedOrder.Gender.MASCULINE, ""),
                Arguments.of(1 , NamedOrder.Gender.FEMININE , "тысяч"),
                Arguments.of(2 , NamedOrder.Gender.MASCULINE, "миллион"),
                Arguments.of(3 , NamedOrder.Gender.MASCULINE, "миллиард"),
                Arguments.of(4 , NamedOrder.Gender.MASCULINE, "триллион"),
                Arguments.of(5 , NamedOrder.Gender.MASCULINE, "квадриллион"),
                Arguments.of(6 , NamedOrder.Gender.MASCULINE, "квинтиллион"),
                Arguments.of(7 , NamedOrder.Gender.MASCULINE, "секстиллион"),
                Arguments.of(8 , NamedOrder.Gender.MASCULINE, "септиллион"),
                Arguments.of(9 , NamedOrder.Gender.MASCULINE, "октиллион"),
                Arguments.of(10, NamedOrder.Gender.MASCULINE, "нониллион"),
                Arguments.of(11, NamedOrder.Gender.MASCULINE, "дециллион"),
                Arguments.of(12, NamedOrder.Gender.MASCULINE, "ундециллион"),
                Arguments.of(13, NamedOrder.Gender.MASCULINE, "додециллион"),
                Arguments.of(14, NamedOrder.Gender.MASCULINE, "тредециллион"),
                Arguments.of(15, NamedOrder.Gender.MASCULINE, "кваттуордециллион"),
                Arguments.of(16, NamedOrder.Gender.MASCULINE, "квиндециллион"),
                Arguments.of(17, NamedOrder.Gender.MASCULINE, "сексдециллион"),
                Arguments.of(18, NamedOrder.Gender.MASCULINE, "септемдециллион"),
                Arguments.of(19, NamedOrder.Gender.MASCULINE, "октодециллион"),
                Arguments.of(20, NamedOrder.Gender.MASCULINE, "новемдециллион"),
                Arguments.of(21, NamedOrder.Gender.MASCULINE, "вигинтиллион"),
                Arguments.of(22, NamedOrder.Gender.MASCULINE, "унвигинтиллион"),
                Arguments.of(23, NamedOrder.Gender.MASCULINE, "дуовигинтиллион"),
                Arguments.of(24, NamedOrder.Gender.MASCULINE, "тревигинтиллион"),
                Arguments.of(25, NamedOrder.Gender.MASCULINE, "кватуорвигинтиллион"),
                Arguments.of(26, NamedOrder.Gender.MASCULINE, "квинвигинтиллион"),
                Arguments.of(27, NamedOrder.Gender.MASCULINE, "сексвигинтиллион"),
                Arguments.of(28, NamedOrder.Gender.MASCULINE, "септенвигинтиллион"),
                Arguments.of(29, NamedOrder.Gender.MASCULINE, "октовигинтиллион"),
                Arguments.of(30, NamedOrder.Gender.MASCULINE, "новемвигинтиллион"),
                Arguments.of(31, NamedOrder.Gender.MASCULINE, "тригинтиллион"),
                Arguments.of(32, NamedOrder.Gender.MASCULINE, "унтригинтиллион"),
                Arguments.of(33, NamedOrder.Gender.MASCULINE, "дуотригинтиллион"),
                Arguments.of(34, NamedOrder.Gender.MASCULINE, "третригинтиллион"),
                Arguments.of(35, NamedOrder.Gender.MASCULINE, "кватортригинтиллион"),
                Arguments.of(36, NamedOrder.Gender.MASCULINE, "квинтригинтиллион"),
                Arguments.of(37, NamedOrder.Gender.MASCULINE, "секстригинтиллион")
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
    void namedOrdersByNumber(int namedOrderNumber, NamedOrder.Gender expectedGender, String expectedRoot) {
        NamedOrder namedOrder = namedOrdersRepository.getByNumber(namedOrderNumber);
        assertEquals(expectedGender, namedOrder.getGender());
        assertEquals(expectedRoot, namedOrder.getRoot());
    }
}
