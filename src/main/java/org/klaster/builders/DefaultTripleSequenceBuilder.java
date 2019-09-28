package org.klaster.builders;

import org.klaster.interfaces.TripleSequenceBuilder;
import org.klaster.models.Triple;
import org.klaster.models.TripleSequence;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
public class DefaultTripleSequenceBuilder implements TripleSequenceBuilder {
    private TripleSequence result;

    public DefaultTripleSequenceBuilder() {
        reset();
    }

    public TripleSequenceBuilder withTriples(Triple... triples) {
        for (Triple triple : triples) result.getTriples().add(triple);
        return this;
    }

    @Override
    public TripleSequenceBuilder withTriples(List<Triple> triples) {
        result.setTriples(triples);
        return this;
    }

    @Override
    public TripleSequence getResult() {
        return result;
    }

    @Override
    public void reset() {
        result = new TripleSequence();
        withTriples(new LinkedList<>());
    }
}
