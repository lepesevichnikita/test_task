package org.klaster.models;

import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
public class Triple {
    private List<Digit> digits;
    private NamedOrder  namedOrder;

    public NamedOrder.Gender getGender() {
        assert (namedOrder != null);
        NamedOrder.Gender result = namedOrder.getGender();
        return result;
    }

    public NamedOrder.Case getCase() {
        assert (digits != null);
        NamedOrder.Case result = NamedOrder.Case.NOMINATIVE;
        if (!digits.isEmpty()) result = digits.get(digits.size() - 1).getCase();
        return result;
    }

    public NamedOrder.Form getForm() {
        assert (digits != null);
        NamedOrder.Form result = NamedOrder.Form.SINGULAR;
        if (!digits.isEmpty()) result = digits.get(digits.size() - 1).getForm();
        return result;
    }


    public List<Digit> getDigits() {
        return this.digits;
    }

    public void setDigits(List<Digit> digits) {
        assert (digits.size() <= 3);
        this.digits = digits;
    }


    public NamedOrder getNamedOrder() {
        return namedOrder;
    }

    public void setNamedOrder(NamedOrder namedOrder) {
        this.namedOrder = namedOrder;
    }
}
