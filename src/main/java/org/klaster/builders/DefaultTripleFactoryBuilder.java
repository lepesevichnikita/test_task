package org.klaster.builders;

import org.klaster.factories.DefaultDigitsRepositoryFactory;
import org.klaster.factories.DefaultTripleFactory;
import org.klaster.interfaces.DigitsRepository;
import org.klaster.interfaces.TripleBuilder;
import org.klaster.interfaces.TripleFactory;
import org.klaster.interfaces.TripleFactoryBuilder;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultTripleFactoryBuilder implements TripleFactoryBuilder {
    private DigitsRepository digitsRepository;
    private TripleBuilder    tripleBuilder;
    private String           source;

    public DefaultTripleFactoryBuilder() { reset(); }

    @Override
    public TripleFactoryBuilder withTripleBuilder(TripleBuilder tripleBuilder) {
        this.tripleBuilder = tripleBuilder;
        return this;
    }

    @Override
    public TripleFactoryBuilder withDigitsRepository(DigitsRepository digitsRepository) {
        this.digitsRepository = digitsRepository;
        return this;
    }

    @Override
    public TripleFactoryBuilder withSource(String source) {
        this.source = source;
        return this;
    }

    public TripleFactory getResult() {
        TripleFactory result = new DefaultTripleFactory();
        result.setSource(source);
        result.setDigitsRepository(digitsRepository);
        result.setTripleBuilder(tripleBuilder);
        return result;
    }

    public void reset() {
        digitsRepository = new DefaultDigitsRepositoryFactory().create();
        tripleBuilder    = new DefaultTripleBuilder();
        source           = "";
    }

}
