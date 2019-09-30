package org.klaster.interfaces;

import org.klaster.models.TripleSequence;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleSequenceRepresenter<T> extends Representer<TripleSequence, T> {
    TripleSequenceRepresenter<T> withTripleRepresenter(TripleRepresenter<T> tripleRepresenter);
}
