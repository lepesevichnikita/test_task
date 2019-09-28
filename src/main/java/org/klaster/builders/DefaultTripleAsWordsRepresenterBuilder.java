package org.klaster.builders;

import org.klaster.builders.DigitsGenderFormsBuilder;
import org.klaster.builders.NamedOrdersFormsBuilder;
import org.klaster.models.Triple;
import org.klaster.services.TripleAsWordsRepresenter;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultTripleAsWordsRepresenterBuilder {
    private DigitsGenderFormsBuilder digitsGenderFormsBuilder;
    private NamedOrdersFormsBuilder  namedOrdersFormsBuilder;
    private Triple                   triple;

    public DefaultTripleAsWordsRepresenterBuilder() { reset(); }

    public DefaultTripleAsWordsRepresenterBuilder withDigitsGenderFormsBuilder(DigitsGenderFormsBuilder digitsGenderFormsBuilder) {
        this.digitsGenderFormsBuilder = digitsGenderFormsBuilder;
        return this;
    }

    public DefaultTripleAsWordsRepresenterBuilder withNamedOrdersFormsBuilder(NamedOrdersFormsBuilder namedOrdersFormsBuilder) {
        this.namedOrdersFormsBuilder = namedOrdersFormsBuilder;
        return this;
    }

    public DefaultTripleAsWordsRepresenterBuilder withTriple(Triple triple) {
        this.triple = triple;
        return this;
    }

    public TripleAsWordsRepresenter getResult() {
        TripleAsWordsRepresenter result = new TripleAsWordsRepresenter();
        result.setTriple(triple);
        result.setNamedOrdersFormsBuilder(namedOrdersFormsBuilder);
        result.setDigitsGenderFormsBuilder(digitsGenderFormsBuilder);
        return result;
    }

    public void reset() {
        digitsGenderFormsBuilder = new DigitsGenderFormsBuilder();
        namedOrdersFormsBuilder  = new NamedOrdersFormsBuilder();
        triple                   = new DefaultTripleBuilder().getResult();
    }
}
