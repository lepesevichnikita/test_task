package org.klaster.services;

import org.klaster.interfaces.SuffixesRepository;
import org.klaster.models.Declension;
import org.klaster.models.Suffix;

import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public class DefaultSuffixesRepository implements SuffixesRepository {
    List<Suffix> items;

    @Override
    public Suffix getSuffixByDeclension(Declension declension) {
        Suffix result = items.stream()
                             .filter(sfx -> sfx.getDeclension().equals(declension))
                             .findFirst()
                             .orElse(null);
        return result;
    }

    @Override
    public List<Suffix> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Suffix> items) {
        this.items = items;
    }
}
