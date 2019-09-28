package org.klaster.models;

import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
public class Triple {
    private List<Digit> digits;
    private NamedOrder  namedOrder;

    public Declension.Gender getGender() {
        assert (namedOrder != null);
        Declension.Gender result = namedOrder.getGender();
        return result;
    }

    public Declension.Case getCase() {
        assert (digits != null);
        Declension.Case result = Declension.Case.NOMINATIVE;
        if (!digits.isEmpty()) result = digits.get(digits.size() - 1).getCase();
        return result;
    }

    public Declension.Form getForm() {
        assert (digits != null);
        Declension.Form result = Declension.Form.SINGULAR;
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

    public boolean isZero() {
        boolean result = digits.stream().allMatch(d -> d.getSymbol().equals("0"));
        return result;
    }

    public boolean isEmpty() {
        boolean result = isZero() && namedOrder.getNumber() > 0;
        return result;
    }
}
