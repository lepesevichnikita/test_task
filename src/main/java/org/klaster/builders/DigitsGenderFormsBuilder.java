package org.klaster.builders;

import org.klaster.models.Declension;
import org.klaster.models.Digit;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DigitsGenderFormsBuilder {
    private Digit             digit;
    private Declension.Gender gender;

    public DigitsGenderFormsBuilder() {
        reset();
    }

    public void reset() {
        digit  = null;
        gender = Declension.Gender.MASCULINE;
    }

    public DigitsGenderFormsBuilder withDigit(Digit digit) {
        this.digit = digit;
        return this;
    }

    public DigitsGenderFormsBuilder withGender(Declension.Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getResult() {
        assert(digit != null);
        String result = digit.getGenderForm(gender);
        if (result.isEmpty() && gender != Declension.Gender.MASCULINE) {
            result = digit.getGenderForm(Declension.Gender.MASCULINE);
        }
        return result;
    }
}
