package org.klaster.builders;

import org.klaster.models.Digit;
import org.klaster.models.NamedOrder;
import org.klaster.models.Triple;

import java.util.LinkedList;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
public class TripleBuilder {
    private Triple result;

    public TripleBuilder() {
        reset();
    }

    public void reset() {
        result = new Triple();
        result.setDigits(new LinkedList<>());
        result.setNamedOrder(new NamedOrder());
    }

    public TripleBuilder withNamedOrder(NamedOrder namedOrder) {
        this.result.setNamedOrder(namedOrder);
        return this;
    }

    public TripleBuilder withDigits(Digit... digits) {
        assert (result.getDigits().size() + digits.length <= 3);
        for (Digit digit : digits) result.getDigits().add(digit);
        return this;
    }

    public Triple getResult() {
        return result;
    }
}
