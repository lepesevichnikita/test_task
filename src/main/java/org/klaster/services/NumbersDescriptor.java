package org.klaster.services;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/23/19
 * @project testtask
 */
public class NumbersDescriptor {
    private String number;

    public NumbersDescriptor(String number) {
        this.number = number;
    }

    public static int numOrder(String number) {
        return number.length() - 1;
    }

    public static int namedNumOrder(String number) {
        final int order = numOrder(number);
        final int result = order < 3 || order % 3 == 0 ? order : order - (order % 3);
        return result;
    }

    public int getNumOrder() {
        return numOrder(this.number);
    }

    public int getNamedNumOrder() {
        return namedNumOrder(this.number);
    }
}
