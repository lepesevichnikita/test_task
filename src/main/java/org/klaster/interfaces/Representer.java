package org.klaster.interfaces;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface Representer<S, T> {
    T from(S source);

    void reset();
}
