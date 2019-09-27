package org.klaster.factories;

import org.klaster.builders.TripleSequenceBuilder;
import org.klaster.models.Triple;
import org.klaster.models.TripleSequence;
import org.klaster.services.NamedOrdersRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
public class TripleSequenceFactory {
    private NamedOrdersRepository namedOrdersRepository;
    private String                source;
    private TripleFactory         tripleFactory;
    private TripleSequenceBuilder tripleSequenceBuilder;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public TripleSequence createTripleSequence() {
        assert (!source.isEmpty());
        assert (tripleSequenceBuilder != null);
        assert (tripleFactory != null);
        assert (namedOrdersRepository != null);
        tripleSequenceBuilder.reset();
        List<Triple> triples = getTriplesFromSource();
        for (int i = 0; i < triples.size(); i++) {
            triples.get(i).setNamedOrder(namedOrdersRepository.getByNamedOrderNumber(i));
        }
        tripleSequenceBuilder.withTriples(triples);
        TripleSequence result = tripleSequenceBuilder.getResult();
        return result;
    }

    public TripleFactory getTripleFactory() {
        return tripleFactory;
    }

    public void setTripleFactory(TripleFactory tripleFactory) {
        this.tripleFactory = tripleFactory;
    }

    public NamedOrdersRepository getNamedOrdersRepository() { return namedOrdersRepository; }

    public void setNamedOrdersRepository(NamedOrdersRepository namedOrdersRepository) {
        this.namedOrdersRepository = namedOrdersRepository;
    }

    public TripleSequenceBuilder getTripleSequenceBuilder() { return tripleSequenceBuilder; }

    public void setTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder) {
        this.tripleSequenceBuilder = tripleSequenceBuilder;
    }

    private List<String> sliceSourceIntoTriples() {
        List<String> result = sliceStringBy(source, 3);
        return result;
    }

    private List<String> sliceStringBy(String string, int size) {
        List<String> result = new LinkedList<>();
        int sourceLength = string.length();
        int startOfRange = 0;
        int endOfRange = sourceLength / size;
        if (endOfRange * size < sourceLength) endOfRange += 1;
        int difference = sourceLength % size;
        int offset = size - difference;
        IntStream.range(startOfRange, endOfRange).forEach(pos -> {
            int start = pos * size;
            if (difference > 0 && pos > 0) start -= offset;
            int end = start + size;
            if (difference > 0 && pos == 0) end -= offset;
            if (end > sourceLength) end = sourceLength;
            result.add(string.substring(start, end));
        });
        return result;
    }

    private List<Triple> getTriplesFromSource() {
        List<Triple> result = sliceSourceIntoTriples().stream().map(s -> {
            tripleFactory.setSource(s);
            return tripleFactory.createTriple();
        }).collect(Collectors.toList());
        return result;
    }
}
