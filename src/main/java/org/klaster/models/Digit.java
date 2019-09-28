package org.klaster.models;

import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class Digit {
    private Map<Declension.Gender, String> genders;
    private Declension.Case                aCase;
    private Declension.Form                form;
    private String                         symbol;
    private int                            positionInTriple;

    public String getSymbol()                                        { return symbol; }

    public void setSymbol(String symbol)                             { this.symbol = symbol; }

    public Declension.Form getForm()                                 { return form == null ? getDefaulForm() : form; }

    public void setForm(Declension.Form form)                        { this.form = form; }

    public Declension.Case getCase()                                 { return aCase == null ? getDefaulCase() : aCase; }

    public void setCase(Declension.Case aCase)                       { this.aCase = aCase; }

    public int getPositionInTriple()                                 { return positionInTriple; }

    public void setPositionInTriple(int positionInTriple)            { this.positionInTriple = positionInTriple; }

    public void setGenderForm(Declension.Gender gender, String form) { genders.put(gender, form); }

    public Declension.Case getDefaulCase()                           { return Declension.Case.GENITIVE; }

    public Declension.Form getDefaulForm()                           { return Declension.Form.PLURAL; }

    public String getGenderForm(Declension.Gender gender) {
        String result = genders.get(gender);
        if (result == null) {
            result = "";
            genders.put(gender, result);
        }
        return result;
    }

    public Map<Declension.Gender, String> getGenders()             { return this.genders; }

    public void setGenders(Map<Declension.Gender, String> genders) { this.genders = genders; }
}
