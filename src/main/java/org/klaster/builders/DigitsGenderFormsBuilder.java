package org.klaster.builders;

import org.klaster.models.Digit;
import org.klaster.models.NamedOrder;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DigitsGenderFormsBuilder {
    private Digit             digit;
    private NamedOrder.Gender gender;

    public DigitsGenderFormsBuilder() {
        reset();
    }

    public void reset() {
        digit  = null;
        gender = NamedOrder.Gender.MASCULINE;
    }

    public DigitsGenderFormsBuilder withDigit(Digit digit) {
        this.digit = digit;
        return this;
    }

    public DigitsGenderFormsBuilder withGender(NamedOrder.Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getResult() {
        assert(digit != null);
        String result = digit.getGenderForm(gender);
        if (result.isEmpty() && gender != NamedOrder.Gender.MASCULINE) {
            result = digit.getGenderForm(NamedOrder.Gender.MASCULINE);
        }
        return result;
    }
}
