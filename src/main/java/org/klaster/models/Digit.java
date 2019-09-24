package org.klaster.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class Digit {
    private String              value;
    private Map<String, String> underTen = new HashMap<String, String>() {
        {
            put("0", "ноль");
            put("1", "один");
            put("2", "два");
            put("3", "три");
            put("4", "четыре");
            put("5", "пять");
            put("6", "шесть");
            put("7", "семь");
            put("8", "восемь");
            put("9", "девять");

        }
    };

    private Map<String, String> betweenTenAndTwenty = new HashMap<String, String>() {{
        put("10", "десять");
        put("11", "одиннадцать");
        put("12", "двенадцать");
        put("13", "тринадцать");
        put("14", "четырнадцать");
        put("15", "пятнадцать");
        put("16", "шестнадцать");
        put("17", "семнадцать");
        put("18", "восемнадцать");
        put("19", "девятнадцать");
    }};

    public Digit() {
        this.currentGender = NamedOrder.Gender.MASCULINE;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public String getDigit() {
        return digit;
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
        return forms.get(gender);
    }

    public void setForm(NamedOrder.Gender gender, String form) {
        forms.put(gender, form);
    }

    public Map<NamedOrder.Gender, String> getForms() { return this.forms; }

    public String toString() {
        String result = forms.get(currentGender);
        result = result.isEmpty() ? forms.get(NamedOrder.Gender.MASCULINE) : result;
        return result;
    }

    private Map<NamedOrder.Gender, String> forms = new HashMap<NamedOrder.Gender, String>() {{
        put(NamedOrder.Gender.FEMININE, "");
        put(NamedOrder.Gender.NEUTER, "");
        put(NamedOrder.Gender.MASCULINE, "");
    }};


    private NamedOrder.Case   requiredNamedOrderCase;
    private NamedOrder.Form   requiredNamedOrderForm;
    private NamedOrder.Gender currentGender;
    private String            digit;
    private int               positionInTriple;
}
