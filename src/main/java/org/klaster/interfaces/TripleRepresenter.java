package org.klaster.interfaces;

import org.klaster.models.Triple;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleRepresenter<T> extends Representer<Triple, T> {
    TripleRepresenter<T> withDigitsGenderFormsBuilder(DigitAsStringRepresenter digitAsStringRepresenter);

    TripleRepresenter<T> withNamedOrdersFormsBuilder(NamedOrdersAsStringRepresenter namedOrdersFormsRepresenter);
}
