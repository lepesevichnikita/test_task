package org.klaster.services;

import org.klaster.models.TripleSequence;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/27/19
 * @project testtask
 */
public class TriplesSequenceAsWordsRepresenter {
    private TripleAsWordsRepresenter tripleAsWordsRepresenter;
    private TripleSequence           tripleSequence;

    public TripleAsWordsRepresenter getTripleAsWordsRepresenter() {
        return tripleAsWordsRepresenter;
    }

    public void setTripleAsWordsRepresenter(TripleAsWordsRepresenter tripleAsWordsRepresenter) {
        this.tripleAsWordsRepresenter = tripleAsWordsRepresenter;
    }

    public TripleSequence getTripleSequence() {
        return tripleSequence;
    }

    public void setTripleSequence(TripleSequence tripleSequence) {
        this.tripleSequence = tripleSequence;
    }

    public String asString() {
        assert (tripleSequence != null);
        assert (tripleAsWordsRepresenter != null);
        List<String> tripleSequencesAsString =
                tripleSequence.getTriples().stream()
                              .filter(triple -> !triple.isEmpty())
                              .map(triple -> {
                                  tripleAsWordsRepresenter.setTriple(triple);
                                  return tripleAsWordsRepresenter.asString();
                              }).collect(Collectors.toList());
        String result = String.join(" ", tripleSequencesAsString).trim();
        return result;
    }
}
