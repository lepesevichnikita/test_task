package org.klaster.interfaces;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface TripleAsStringRepresenter extends TripleRepresenter<String> {
    DigitRepresenter getDigitAsStringRepresenter();

    TripleAsStringRepresenter withDigitsGenderFormsBuilder(DigitAsStringRepresenter digitAsStringRepresenter);

    TripleAsStringRepresenter withNamedOrdersFormsBuilder(NamedOrdersAsStringRepresenter namedOrdersFormsRepresenter);
}
