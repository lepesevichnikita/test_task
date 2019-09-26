package org.klaster.builders;

import org.klaster.models.Triple;
import org.klaster.models.TripleSequence;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
public class TripleSequenceBuilder {
    private TripleSequence result;

    public TripleSequenceBuilder() {
        reset();
    }

    public TripleSequenceBuilder withTriples(Triple... triples) {
        for (Triple triple : triples) result.getTriples().add(triple);
        return this;
    }

    public TripleSequenceBuilder withTriples(List<Triple> triples) {
        result.setTriples(triples);
        return this;
    }

    public TripleSequence getResult() {
        return result;
    }

    public void reset() {
        result = new TripleSequence();
        withTriples(new LinkedList<>());
    }
}
