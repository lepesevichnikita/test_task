package org.klaster.services;

import org.klaster.interfaces.NamedOrdersRepository;
import org.klaster.models.NamedOrder;

import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DefaultNamedOrdersRepository implements NamedOrdersRepository {
    private List<NamedOrder> items;

    @Override
    public List<NamedOrder> getItems() { return items; }

    @Override
    public void setItems(List<NamedOrder> items) { this.items = items; }

    @Override
    public NamedOrder getByNumber(int namedOrderNumber) {
        NamedOrder result =
                items.parallelStream()
                     .filter(no -> no.getNumber() == namedOrderNumber)
                     .findFirst()
                     .orElse(null);
        return result;
    }
}
