package org.klaster.interfaces;

import org.klaster.models.Triple;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleAsStringRepresenterBuilder extends TripleRepresenterBuilder<String> {
    TripleRepresenterBuilder withDigitsGenderFormsBuilder(DigitAsStringRepresenter digitAsStringRepresenter);

    TripleRepresenterBuilder withNamedOrdersFormsBuilder(NamedOrdersAsStringRepresenter namedOrdersFormsRepresenter);

    TripleRepresenterBuilder withTriple(Triple triple);

}
