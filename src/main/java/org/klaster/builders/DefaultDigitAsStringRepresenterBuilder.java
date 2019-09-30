package org.klaster.builders;

import org.klaster.interfaces.DigitAsStringRepresenter;
import org.klaster.interfaces.DigitAsStringRepresenterBuilder;
import org.klaster.models.Declension;
import org.klaster.representers.DefaultDigitAsStringRepresenter;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public class DefaultDigitAsStringRepresenterBuilder implements DigitAsStringRepresenterBuilder {
    private Declension.Gender gender;

    public DefaultDigitAsStringRepresenterBuilder() { reset(); }

    @Override
    public DigitAsStringRepresenterBuilder withGender(Declension.Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public DigitAsStringRepresenter getResult() {
        DigitAsStringRepresenter result = new DefaultDigitAsStringRepresenter();
        result.withGender(gender);
        return result;
    }

    @Override
    public void reset() {
        gender = Declension.Gender.MASCULINE;
    }
}
