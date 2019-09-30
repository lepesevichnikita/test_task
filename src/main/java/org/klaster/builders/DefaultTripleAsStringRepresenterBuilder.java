package org.klaster.builders;

import org.klaster.interfaces.*;
import org.klaster.models.Triple;
import org.klaster.representers.DefaultDigitAsStringRepresenter;
import org.klaster.representers.DefaultTripleAsStringRepresenter;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultTripleAsStringRepresenterBuilder implements TripleAsStringRepresenterBuilder {
    private DigitAsStringRepresenter       digitAsStringRepresenter;
    private NamedOrdersAsStringRepresenter namedOrdersFormsRepresenter;
    private Triple                         triple;

    public DefaultTripleAsStringRepresenterBuilder() { reset(); }

    @Override
    public TripleRepresenterBuilder withDigitsGenderFormsBuilder(DigitAsStringRepresenter digitAsStringRepresenter) {
        this.digitAsStringRepresenter = digitAsStringRepresenter;
        return this;
    }

    @Override
    public TripleRepresenterBuilder withNamedOrdersFormsBuilder(NamedOrdersAsStringRepresenter namedOrdersFormsRepresenter) {
        this.namedOrdersFormsRepresenter = namedOrdersFormsRepresenter;
        return this;
    }

    @Override
    public TripleRepresenterBuilder withTriple(Triple triple) {
        this.triple = triple;
        return this;
    }

    @Override
    public TripleAsStringRepresenter getResult() {
        TripleAsStringRepresenter result = new DefaultTripleAsStringRepresenter();
        result.withNamedOrdersFormsBuilder(namedOrdersFormsRepresenter);
        result.withDigitsGenderFormsBuilder(digitAsStringRepresenter);
        return result;
    }

    @Override
    public void reset() {
        digitAsStringRepresenter    = new DefaultDigitAsStringRepresenter();
        namedOrdersFormsRepresenter = new DefaultNamedOrdersAsStringRepresenterBuilder().getResult();
    }
}
