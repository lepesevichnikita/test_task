package org.klaster.interfaces;

import org.klaster.models.Digit;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface DigitsRepository extends DictionaryRepository<Digit> {
    Digit getDigitByPositionInTripleAndSymbol(String symbol, int positionInTriple);
}
