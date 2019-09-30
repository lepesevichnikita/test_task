package org.klaster.builders;

import org.klaster.interfaces.*;
import org.klaster.representers.DefaultTripleSequenceAsStringRepresenter;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultTripleSequenceAsStringRepresenterBuilder implements TripleSequenceAsStringRepresenterBuilder {
    private TripleAsStringRepresenter tripleAsStringRepresenter;

    public DefaultTripleSequenceAsStringRepresenterBuilder() { reset(); }

    @Override
    public TripleSequenceRepresenterBuilder withTripleRepresenter(TripleRepresenter tripleRepresenter) {
        this.tripleAsStringRepresenter = (TripleAsStringRepresenter) tripleRepresenter;
        return this;
    }

    @Override
    public TripleSequenceAsStringRepresenter getResult() {
        TripleSequenceAsStringRepresenter result = new DefaultTripleSequenceAsStringRepresenter();
        result.withTripleRepresenter(tripleAsStringRepresenter);
        return result;
    }

    @Override
    public void reset() {
        tripleAsStringRepresenter = new DefaultTripleAsStringRepresenterBuilder().getResult();
    }
}
