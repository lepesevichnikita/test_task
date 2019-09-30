package org.klaster.representers;

import org.klaster.builders.DefaultTripleAsStringRepresenterBuilder;
import org.klaster.builders.DefaultTripleSequenceBuilder;
import org.klaster.interfaces.TripleAsStringRepresenter;
import org.klaster.interfaces.TripleRepresenter;
import org.klaster.interfaces.TripleSequenceAsStringRepresenter;
import org.klaster.models.TripleSequence;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/27/19
 * @project testtask
 */
public class DefaultTripleSequenceAsStringRepresenter implements TripleSequenceAsStringRepresenter {
    private TripleAsStringRepresenter tripleAsStringRepresenter;
    private TripleSequence            tripleSequence;

    @Override
    public TripleSequenceAsStringRepresenter withTripleRepresenter(TripleRepresenter tripleRepresenter) {
        this.tripleAsStringRepresenter = (TripleAsStringRepresenter) tripleRepresenter;
        return this;
    }

    @Override
    public String from(TripleSequence sourceTripleSequence) {
        this.tripleSequence = sourceTripleSequence;
        return getResult();
    }

    private String getResult() {
        List<String> tripleSequencesAsString =
                tripleSequence.getTriples()
                              .stream()
                              .filter(triple -> !triple.isEmpty())
                              .map(triple -> tripleAsStringRepresenter.from(triple))
                              .collect(Collectors.toList());
        String result = String.join(" ", tripleSequencesAsString).trim();
        return result;
    }

    @Override
    public void reset() {
        tripleAsStringRepresenter = new DefaultTripleAsStringRepresenterBuilder().getResult();
        tripleSequence            = new DefaultTripleSequenceBuilder().getResult();
    }
}

