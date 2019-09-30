package org.klaster.interfaces;

import org.klaster.models.Digit;
import org.klaster.models.NamedOrder;
import org.klaster.models.Triple;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface TripleBuilder extends Builder<Triple> {
    TripleBuilder withNamedOrder(NamedOrder namedOrder);

    TripleBuilder withDigits(Digit... digits);
}
