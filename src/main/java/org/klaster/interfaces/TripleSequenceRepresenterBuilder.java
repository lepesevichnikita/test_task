package org.klaster.interfaces;

import org.klaster.models.TripleSequence;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleSequenceRepresenterBuilder<T> extends RepresenterBuilder<Representer<TripleSequence, T>> {
    TripleSequenceRepresenterBuilder withTripleRepresenter(TripleRepresenter tripleRepresenter);
}
