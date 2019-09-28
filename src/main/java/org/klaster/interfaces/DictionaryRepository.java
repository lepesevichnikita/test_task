package org.klaster.interfaces;

import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface DictionaryRepository<T> {
    List<T> getItems();

    void setItems(List<T> items);
}
