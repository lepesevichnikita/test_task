package org.klaster.interfaces;

import org.klaster.models.Declension;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface NamedOrdersAsStringRepresenterBuilder extends NamedOrdersRepresenterBuilder<String> {
    NamedOrdersRepresenterBuilder withForm(Declension.Form form);

    NamedOrdersRepresenterBuilder withCase(Declension.Case aCase);

    NamedOrdersRepresenterBuilder withSuffixesRepository(SuffixesRepository suffixesRepository);
}
