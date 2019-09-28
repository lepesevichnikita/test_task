package org.klaster.builders;

import org.klaster.interfaces.DigitBuilder;
import org.klaster.models.Declension;
import org.klaster.models.Digit;

import java.util.HashMap;
import java.util.Map;

public class DefaultDigitBuilder implements DigitBuilder {
    Digit result;

    public DefaultDigitBuilder() {
        reset();
    }

    @Override
    public DigitBuilder withGenders(Map<Declension.Gender, String> genders) {
        result.setGenders(genders);
        return this;
    }

    @Override
    public DigitBuilder withCase(Declension.Case aCase) {
        result.setCase(aCase);
        return this;
    }

    @Override
    public DigitBuilder withForm(Declension.Form form) {
        result.setForm(form);
        return this;
    }

    @Override
    public DigitBuilder withSymbol(String symbol) {
        result.setSymbol(symbol);
        return this;
    }

    @Override
    public DigitBuilder withPositionInTriple(int positionInTriple) {
        result.setPositionInTriple(positionInTriple);
        return this;
    }

    @Override
    public Digit getResult() {
        return result;
    }

    @Override
    public Digit getResult(Map<Declension.Gender, String> genders, Declension.Case aCase,
                           Declension.Form form, String symbol) {
        return withGenders(genders).withCase(aCase).withForm(form).withSymbol(symbol).getResult();
    }

    @Override
    public void reset() {
        result = new Digit();
        withGenders(new HashMap<>()).withForm(Declension.Form.PLURAL).withSymbol("").withCase(Declension.Case.GENITIVE);
    }
}