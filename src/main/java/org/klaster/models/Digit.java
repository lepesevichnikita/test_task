package org.klaster.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class Digit {
    private Map<NamedOrder.Gender, String> genders;
    private NamedOrder.Case                aCase;
    private NamedOrder.Form                form;
    private String                         digit;
    private int                            positionInTriple;

    public Digit() {
        this.aCase   = NamedOrder.Case.GENITIVE;
        this.form    = NamedOrder.Form.PLURAL;
        this.genders = new HashMap<NamedOrder.Gender, String>();
    }

    public String getDigit()                              { return digit; }

    public void setDigit(String digit)                    { this.digit = digit; }

    public NamedOrder.Form getForm()                      { return form; }

    public void setForm(NamedOrder.Form form)             { this.form = form; }

    public NamedOrder.Case getCase()                      { return aCase; }

    public void setCase(NamedOrder.Case aCase)            { this.aCase = aCase; }

    public int getPositionInTriple()                      { return positionInTriple; }

    public void setPositionInTriple(int positionInTriple) { this.positionInTriple = positionInTriple; }

    public String getForm(NamedOrder.Gender gender) {
        String result = genders.get(gender);
        if (result == null) {
            result = "";
            genders.put(gender, result);
        }
        return result;
    }

    public void setGenderForm(NamedOrder.Gender gender, String form) { genders.put(gender, form); }

    public Map<NamedOrder.Gender, String> getGenders()               { return this.genders; }

    public void setGenders(Map<NamedOrder.Gender, String> genders)   { this.genders = genders; }
}
