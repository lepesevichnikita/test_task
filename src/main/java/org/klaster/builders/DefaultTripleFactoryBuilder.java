package org.klaster.builders;

import org.klaster.factories.DefaultDigitsRepositoryFactory;
import org.klaster.factories.TripleFactory;
import org.klaster.interfaces.DigitsRepository;
import org.klaster.interfaces.TripleBuilder;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultTripleFactoryBuilder {
    private DigitsRepository digitsRepository;
    private TripleBuilder    tripleBuilder;
    private TripleFactory    result;
    private String           source;

    public DefaultTripleFactoryBuilder() { reset(); }

    public DefaultTripleFactoryBuilder withTripleBuilder(TripleBuilder tripleBuilder) {
        this.tripleBuilder = tripleBuilder;
        return this;
    }

    public DefaultTripleFactoryBuilder withDigitsRepository(DigitsRepository digitsRepository) {
        this.digitsRepository = digitsRepository;
        return this;
    }

    public DefaultTripleFactoryBuilder withSource(String source) {
        this.source = source;
        return this;
    }

    public TripleFactory getResult() {
        result.setSource(source);
        result.setDigitsRepository(digitsRepository);
        result.setTripleBuilder(tripleBuilder);
        return result;
    }

    public void reset() {
        result           = new TripleFactory();
        digitsRepository = new DefaultDigitsRepositoryFactory().loadRepository();
        tripleBuilder    = new DefaultTripleBuilder();
        source           = "";
    }

}
