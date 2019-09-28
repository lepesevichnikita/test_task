package org.klaster.builders;

import org.klaster.factories.DefaultNamedOrdersRepositoryFactory;
import org.klaster.factories.TripleFactory;
import org.klaster.factories.TripleSequenceFactory;
import org.klaster.interfaces.NamedOrdersRepository;
import org.klaster.interfaces.TripleSequenceBuilder;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultTripleSequenceFactoryBuilder {
    private NamedOrdersRepository namedOrdersRepository;
    private String                source;
    private TripleFactory         tripleFactory;
    private TripleSequenceBuilder tripleSequenceBuilder;

    public DefaultTripleSequenceFactoryBuilder() { reset(); }

    public DefaultTripleSequenceFactoryBuilder withNamedOrdersRepository(NamedOrdersRepository namedOrdersRepository) {
        this.namedOrdersRepository = namedOrdersRepository;
        return this;
    }

    public DefaultTripleSequenceFactoryBuilder withSource(String source) {
        this.source = source;
        return this;
    }

    public DefaultTripleSequenceFactoryBuilder withTripleFactory(TripleFactory tripleFactory) {
        this.tripleFactory = tripleFactory;
        return this;
    }

    public DefaultTripleSequenceFactoryBuilder withTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder) {
        this.tripleSequenceBuilder = tripleSequenceBuilder;
        return this;
    }

    public TripleSequenceFactory getResult() {
        TripleSequenceFactory result = new TripleSequenceFactory();
        result.setSource(source);
        result.setNamedOrdersRepository(namedOrdersRepository);
        result.setTripleFactory(tripleFactory);
        result.setTripleSequenceBuilder(tripleSequenceBuilder);
        return result;
    }

    public void reset() {
        namedOrdersRepository = new DefaultNamedOrdersRepositoryFactory().loadRepository();
        source                = "";
        tripleFactory         = new DefaultTripleFactoryBuilder().getResult();
        tripleSequenceBuilder = new DefaultTripleSequenceBuilder();
    }

}
