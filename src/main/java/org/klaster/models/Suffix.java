package org.klaster.models;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */

public class Suffix {
    private Declension declension;
    private String     value;

    public Suffix(Declension declension, String value) {
        this.declension = declension;
        this.value  = value;
    }

    public Suffix()          {}


    public String getValue() { return value; }

    public void setValue(String value) {
        this.value = value;
    }

    public Declension getDeclension() {
        return declension;
    }

    public void setDeclension(Declension declension) {
        this.declension = declension;
    }
}
