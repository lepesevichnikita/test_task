package org.klaster.builders;

import org.klaster.models.Digit;
import org.klaster.models.NamedOrder;

import java.util.HashMap;
import java.util.Map;

public class DigitBuilder {
    Digit result;

    public DigitBuilder() {
        reset();
    }

    public DigitBuilder withGenders(Map<NamedOrder.Gender, String> genders) {
        result.setGenders(genders);
        return this;
    }

    public DigitBuilder withCase(NamedOrder.Case aCase) {
        result.setCase(aCase);
        return this;
    }

    public DigitBuilder withForm(NamedOrder.Form form) {
        result.setForm(form);
        return this;
    }

    public DigitBuilder withSymbol(String symbol) {
        result.setSymbol(symbol);
        return this;
    }

    public DigitBuilder withPositionInTriple(int positionInTriple) {
        result.setPositionInTriple(positionInTriple);
        return this;
    }

    public Digit getResult() {
        return result;
    }

    public Digit getResult(Map<NamedOrder.Gender, String> genders, NamedOrder.Case aCase,
                           NamedOrder.Form form, String symbol) {
        return withGenders(genders).withCase(aCase).withForm(form).withSymbol(symbol).getResult();
    }

    public void reset() {
        result = new Digit();
        withGenders(new HashMap<>()).withForm(NamedOrder.Form.PLURAL).withSymbol("").withCase(NamedOrder.Case.GENITIVE);
    }
}