package org.klaster.interfaces;

import org.klaster.models.Triple;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleFactory extends Factory<Triple> {

    TripleBuilder getTripleBuilder();

    void setTripleBuilder(TripleBuilder tripleBuilder);

    DigitsRepository getDigitsRepository();

    void setDigitsRepository(DigitsRepository digitsRepository);

    String getSource();

    void setSource(String tripleAsString);
}
