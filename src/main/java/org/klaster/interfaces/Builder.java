package org.klaster.interfaces;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface Builder<T> {
    T getResult();

    void reset();
}
