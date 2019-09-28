package org.klaster.factories;

import org.klaster.interfaces.NamedOrdersRepository;
import org.klaster.interfaces.TripleSequenceBuilder;
import org.klaster.models.Triple;
import org.klaster.models.TripleSequence;

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
        createTriplesFromSource();
        TripleSequence result = tripleSequenceBuilder.getResult();
        return result;
    }

    public TripleFactory getTripleFactory() {
        return tripleFactory;
    }

    public void setTripleFactory(TripleFactory tripleFactory) {
        this.tripleFactory = tripleFactory;
    }

    public NamedOrdersRepository getDefaultNamedOrdersRepository() { return namedOrdersRepository; }

    public void setDefaultNamedOrdersRepository(NamedOrdersRepository namedOrdersRepository) {
        this.namedOrdersRepository = namedOrdersRepository;
    }

    public TripleSequenceBuilder getDefaultTripleSequenceBuilder() { return tripleSequenceBuilder; }

    public void setDefaultTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder) {
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

    private void createTriplesFromSource() {
        List<Triple> result = sliceSourceIntoTriples().stream().map(s -> {
            tripleFactory.setSource(s);
            return tripleFactory.createTriple();
        }).collect(Collectors.toList());
        int resultSize = result.size();
        IntStream.range(0, resultSize)
                 .forEach(pos -> {
                     int orderNumber = resultSize - pos - 1;
                     result.get(pos).setNamedOrder(namedOrdersRepository.getByNumber(orderNumber));
                 });
        // if triples don't represent zero remove last triple if it represents zero and there is more han one triple
        // in sequence
        if (!result.stream().allMatch(triple -> triple.isZero())) {
            result.removeIf(triple -> triple.isZero() && resultSize > 1);
        }
        tripleSequenceBuilder.withTriples(result);
    }
}
