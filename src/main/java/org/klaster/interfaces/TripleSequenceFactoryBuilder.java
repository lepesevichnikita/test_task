package org.klaster.interfaces;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleSequenceFactoryBuilder extends Builder<TripleSequenceFactory> {
    TripleSequenceFactoryBuilder withNamedOrdersRepository(NamedOrdersRepository namedOrdersRepository);

    TripleSequenceFactoryBuilder withSource(String source);

    TripleSequenceFactoryBuilder withTripleFactory(TripleFactory tripleFactory);

    TripleSequenceFactoryBuilder withTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder);
}
