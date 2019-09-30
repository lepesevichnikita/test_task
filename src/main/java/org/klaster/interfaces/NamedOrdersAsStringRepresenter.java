package org.klaster.interfaces;

import org.klaster.models.Declension;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface NamedOrdersAsStringRepresenter extends NamedOrdersRepresenter<String> {
    NamedOrdersAsStringRepresenter withSuffixesRepository(SuffixesRepository suffixesRepository);

    NamedOrdersAsStringRepresenter withForm(Declension.Form requiredForm);

    NamedOrdersAsStringRepresenter withCase(Declension.Case requiredCase);

}
