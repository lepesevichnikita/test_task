package org.klaster.models;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */

public class Suffix {
    private final Declension.Gender gender;
    private final Declension.Form   form;
    private final Declension.Case   aCase;
    private final String            value;

    public Suffix(Declension.Gender gender, Declension.Form form, Declension.Case aCase, String value) {
        this.aCase  = aCase;
        this.form   = form;
        this.gender = gender;
        this.value  = value;
    }

    public Declension.Gender getGender() {return gender; }

    public Declension.Form getForm()     {return form; }

    public Declension.Case getCase()     {return aCase; }

    public String getValue()             { return value; }
}
