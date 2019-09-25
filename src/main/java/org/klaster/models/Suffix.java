package org.klaster.models;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */

public class Suffix {
    private final NamedOrder.Gender gender;
    private final NamedOrder.Form   form;
    private final NamedOrder.Case   aCase;
    private final String            value;

    public Suffix(NamedOrder.Gender gender, NamedOrder.Form form, NamedOrder.Case aCase, String value) {
        this.aCase  = aCase;
        this.form   = form;
        this.gender = gender;
        this.value  = value;
    }

    public NamedOrder.Gender getGender() {return gender; }

    public NamedOrder.Form getForm()     {return form; }

    public NamedOrder.Case getCase()     {return aCase; }

    public String getValue()             { return value; }
}
