package org.klaster.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/23/19
 * @project testtask
 */
public class NumbersDescriptorTest {
    private NumbersDescriptor numbersDescriptor;

    private static Stream<Arguments> numbersForNumOrder() {
        return Stream.of(
                Arguments.of("123456789", 8),
                Arguments.of("1", 0),
                Arguments.of("10", 1)
        );
    }

    private static Stream<Arguments> numbersForNamedNumOrder() {
        return Stream.of(
                Arguments.of("1", 0, 0),
                Arguments.of("10", 1, 1),
                Arguments.of("100", 2, 2),
                Arguments.of("1000", 3, 3),
                Arguments.of("10000", 3, 4),
                Arguments.of("100000", 3, 5),
                Arguments.of("1000000", 6, 6)
        );
    }

    @ParameterizedTest
    @DisplayName("Returns valid maximum order of number")
    @MethodSource("numbersForNumOrder")
    void numOrder(String testNumber, int expected) {
        numbersDescriptor = new NumbersDescriptor(testNumber);
        assertEquals(numbersDescriptor.getNumOrder(), expected);
    }

    @ParameterizedTest
    @DisplayName("Returns valid named order of number")
    @MethodSource("numbersForNamedNumOrder")
    void namedNumOrder(String testNumber, int expectedNamedOrder, int expectedSimpleOrder) {
        numbersDescriptor = new NumbersDescriptor(testNumber);
        assertEquals(numbersDescriptor.getNamedNumOrder(), expectedNamedOrder);
        assertEquals(numbersDescriptor.getNumOrder(), expectedSimpleOrder);
    }

}
