package org.klaster.representers;

import org.klaster.interfaces.DigitAsStringRepresenter;
import org.klaster.models.Declension;
import org.klaster.models.Digit;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DefaultDigitAsStringRepresenter implements DigitAsStringRepresenter {
    private Digit             digit;
    private Declension.Gender gender;

    @Override
    public void reset() {
        digit  = null;
        gender = Declension.Gender.MASCULINE;
    }

    @Override
    public String from(Digit digit) {
        this.digit = digit;
        return getResult();
    }

    @Override
    public DigitAsStringRepresenter withGender(Declension.Gender gender) {
        this.gender = gender;
        return this;
    }

    private String getResult() {
        assert(digit != null);
        String result = digit.getGenderForm(gender);
        if (result.isEmpty() && gender != Declension.Gender.MASCULINE) {
            result = digit.getGenderForm(Declension.Gender.MASCULINE);
        }
        return result;
    }
}
