package org.klaster.interfaces;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleFactoryBuilder extends Builder<TripleFactory> {
    TripleFactoryBuilder withTripleBuilder(TripleBuilder tripleBuilder);

    TripleFactoryBuilder withDigitsRepository(DigitsRepository digitsRepository);

    TripleFactoryBuilder withSource(String source);
}
