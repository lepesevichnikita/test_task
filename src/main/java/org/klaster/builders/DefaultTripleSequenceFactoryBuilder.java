package org.klaster.builders;

import org.klaster.factories.DefaultNamedOrdersRepositoryFactory;
import org.klaster.factories.DefaultTripleSequenceFactory;
import org.klaster.interfaces.*;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultTripleSequenceFactoryBuilder implements TripleSequenceFactoryBuilder {
    private NamedOrdersRepository namedOrdersRepository;
    private String                source;
    private TripleFactory         tripleFactory;
    private TripleSequenceBuilder tripleSequenceBuilder;

    public DefaultTripleSequenceFactoryBuilder() { reset(); }

    @Override
    public TripleSequenceFactoryBuilder withNamedOrdersRepository(NamedOrdersRepository namedOrdersRepository) {
        this.namedOrdersRepository = namedOrdersRepository;
        return this;
    }

    @Override
    public TripleSequenceFactoryBuilder withSource(String source) {
        this.source = source;
        return this;
    }

    @Override
    public TripleSequenceFactoryBuilder withTripleFactory(TripleFactory tripleFactory) {
        this.tripleFactory = tripleFactory;
        return this;
    }

    @Override
    public TripleSequenceFactoryBuilder withTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder) {
        this.tripleSequenceBuilder = tripleSequenceBuilder;
        return this;
    }

    @Override
    public TripleSequenceFactory getResult() {
        TripleSequenceFactory result = new DefaultTripleSequenceFactory();
        result.setSource(source);
        result.setNamedOrdersRepository(namedOrdersRepository);
        result.setTripleFactory(tripleFactory);
        result.setTripleSequenceBuilder(tripleSequenceBuilder);
        return result;
    }

    @Override
    public void reset() {
        namedOrdersRepository = new DefaultNamedOrdersRepositoryFactory().create();
        source                = "";
        tripleFactory         = new DefaultTripleFactoryBuilder().getResult();
        tripleSequenceBuilder = new DefaultTripleSequenceBuilder();
    }

}
