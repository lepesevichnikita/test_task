package org.klaster.builders;

import org.klaster.models.TripleSequence;
import org.klaster.services.TripleAsWordsRepresenter;
import org.klaster.services.TriplesSequenceAsWordsRepresenter;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultTripleSequenceAsWordsRepresenterBuilder {
    private TripleAsWordsRepresenter tripleAsWordsRepresenter;
    private TripleSequence           tripleSequence;

    public DefaultTripleSequenceAsWordsRepresenterBuilder() { reset(); }

    public DefaultTripleSequenceAsWordsRepresenterBuilder witTripleAsWordsRepresenter(TripleAsWordsRepresenter tripleAsWordsRepresenter) {
        this.tripleAsWordsRepresenter = tripleAsWordsRepresenter;
        return this;
    }

    public DefaultTripleSequenceAsWordsRepresenterBuilder withTripleSequencer(TripleAsWordsRepresenter tripleAsWordsRepresenter) {
        this.tripleSequence = tripleSequence;
        return this;
    }

    public TriplesSequenceAsWordsRepresenter getResult() {
        TriplesSequenceAsWordsRepresenter result = new TriplesSequenceAsWordsRepresenter();
        result.setTripleAsWordsRepresenter(tripleAsWordsRepresenter);
        result.setTripleSequence(tripleSequence);
        return result;
    }

    public void reset() {
        tripleSequence           = new DefaultTripleSequenceBuilder().getResult();
        tripleAsWordsRepresenter = new DefaultTripleAsWordsRepresenterBuilder().getResult();
    }
}
