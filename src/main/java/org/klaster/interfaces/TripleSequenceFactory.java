package org.klaster.interfaces;

import org.klaster.models.TripleSequence;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleSequenceFactory extends Factory<TripleSequence> {
    String getSource();

    void setSource(String source);

    TripleFactory getTripleFactory();

    void setTripleFactory(TripleFactory tripleFactory);

    NamedOrdersRepository getNamedOrdersRepository();

    void setNamedOrdersRepository(NamedOrdersRepository namedOrdersRepository);

    TripleSequenceBuilder getTripleSequenceBuilder();

    void setTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder);
}
