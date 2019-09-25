package org.klaster.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class Digit {
    private Map<NamedOrder.Gender, String> forms = new HashMap<NamedOrder.Gender, String>() {{
        put(NamedOrder.Gender.FEMININE, "");
        put(NamedOrder.Gender.MASCULINE, "");
    }};
    private NamedOrder.Case                requiredNamedOrderCase;
    private NamedOrder.Form                requiredNamedOrderForm;
    private NamedOrder.Gender              currentGender;
    private String                         digit;
    private int                            positionInTriple;

    public Digit() {
        this.currentGender          = NamedOrder.Gender.MASCULINE;
        this.requiredNamedOrderCase = NamedOrder.Case.GENITIVE;
        this.requiredNamedOrderForm = NamedOrder.Form.PLURAL;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public NamedOrder.Form getRequiredNamedOrderForm() {
        return requiredNamedOrderForm;
    }

    public void setRequiredNamedOrderForm(NamedOrder.Form requiredNamedOrderForm) {
        this.requiredNamedOrderForm = requiredNamedOrderForm;
    }

    public NamedOrder.Case getRequiredNamedOrderCase() {
        return requiredNamedOrderCase;
    }

    public void setRequiredNamedOrderCase(NamedOrder.Case requiredNamedOrderCase) {
        this.requiredNamedOrderCase = requiredNamedOrderCase;
    }

    public NamedOrder.Gender getCurrentGender() {
        return currentGender;
    }

    public void setCurrentGender(NamedOrder.Gender currentGender) {
        this.currentGender = currentGender;
    }

    public int getPositionInTriple() {
        return positionInTriple;
    }

    public void setPositionInTriple(int positionInTriple) {
        this.positionInTriple = positionInTriple;
    }

    public String getForm(NamedOrder.Gender gender) {
        final String result = forms.get(gender);
        return result == null ? "" : result;
    }

    public void setForm(NamedOrder.Gender gender, String form) {
        forms.put(gender, form);
    }

    public Map<NamedOrder.Gender, String> getForms()           { return this.forms; }

    public void setForms(Map<NamedOrder.Gender, String> forms) { this.forms = forms; }

    public String toString() {
        String result = forms.get(currentGender);
        result = result.isEmpty() ? forms.get(NamedOrder.Gender.MASCULINE) : result;
        return result;
    }
}
