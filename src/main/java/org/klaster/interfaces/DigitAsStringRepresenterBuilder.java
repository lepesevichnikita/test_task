package org.klaster.interfaces;

import org.klaster.models.Declension;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface DigitAsStringRepresenterBuilder extends DigitRepresenterBuilder<String> {
    DigitAsStringRepresenterBuilder withGender(Declension.Gender gender);
}
