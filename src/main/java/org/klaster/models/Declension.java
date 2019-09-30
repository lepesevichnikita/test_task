package org.klaster.models;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class Declension {
    private Form   form;
    private Case   aCase;
    private Gender gender;

    public Declension(Case aCase, Form form, Gender gender) {
        this.aCase  = aCase;
        this.form   = form;
        this.gender = gender;
    }

    public Declension() {}

    public boolean equals(Declension declension) {
        return aCase == declension.getaCase() && form == declension.getForm() && gender == declension.getGender();
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Case getaCase() {
        return aCase;
    }

    public void setCase(Case aCase) {
        this.aCase = aCase;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public enum Form {
        PLURAL, SINGULAR
    }

    public enum Gender {
        MASCULINE, FEMININE
    }

    public enum Case {
        NOMINATIVE, GENITIVE
    }
}
