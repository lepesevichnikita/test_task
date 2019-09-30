package org.klaster.interfaces;

import org.klaster.models.Triple;
import org.klaster.models.TripleSequence;

import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface TripleSequenceBuilder extends Builder<TripleSequence> {
    TripleSequenceBuilder withTriples(List<Triple> triples);

    TripleSequence getResult();

    void reset();
}
