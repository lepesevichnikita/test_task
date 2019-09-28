package org.klaster.interfaces;

import org.klaster.models.NamedOrder;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface NamedOrdersRepository extends DictionaryRepository<NamedOrder> {
    NamedOrder getByNumber(int namedOrderNumber);
}
