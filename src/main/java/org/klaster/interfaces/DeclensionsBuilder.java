package org.klaster.interfaces;

import org.klaster.models.Declension;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface DeclensionsBuilder extends Builder<Declension> {
    DeclensionsBuilder withCase(Declension.Case aCase);

    DeclensionsBuilder withForm(Declension.Form form);

    DeclensionsBuilder withGender(Declension.Gender gender);
}
