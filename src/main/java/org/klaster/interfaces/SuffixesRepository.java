package org.klaster.interfaces;

import org.klaster.models.Declension;
import org.klaster.models.Suffix;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface SuffixesRepository extends DictionaryRepository<Suffix> {
    Suffix getSuffixByDeclension(Declension declension);
}
