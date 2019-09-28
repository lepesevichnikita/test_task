package org.klaster.interfaces;

import org.klaster.models.Declension;
import org.klaster.models.Digit;

import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface DigitBuilder extends ModelBuilder<Digit> {
    DigitBuilder withGenders(Map<Declension.Gender, String> genders);

    DigitBuilder withCase(Declension.Case aCase);

    DigitBuilder withForm(Declension.Form form);

    DigitBuilder withSymbol(String symbol);

    DigitBuilder withPositionInTriple(int positionInTriple);

    Digit getResult(Map<Declension.Gender, String> genders, Declension.Case aCase,
                    Declension.Form form, String symbol);

}
