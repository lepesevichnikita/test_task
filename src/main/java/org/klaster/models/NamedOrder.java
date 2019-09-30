package org.klaster.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class NamedOrder {
    private Map<Declension.Form, Map<Declension.Case, String>> forms;
    private Declension.Gender                                  gender;
    private int                                                number;
    private String                                             root;

    public NamedOrder() {
        this.gender = Declension.Gender.MASCULINE;
        this.forms  = new HashMap<Declension.Form, Map<Declension.Case, String>>();
    }

    public Declension.Gender getGender()                           { return gender; }

    public void setGender(Declension.Gender gender)                { this.gender = gender; }


    public int getNumber()                                         { return number; }

    public void setNumber(int number)                              { this.number = number; }


    public String getSingular(Declension.Case wordCase)            { return getSingularCases().get(wordCase); }

    public void setSingular(Declension.Case wordCase, String word) { getSingularCases().put(wordCase, word); }

    public String getPlural(Declension.Case wordCase)              { return getPluralCases().get(wordCase);}

    public void setPlural(Declension.Case wordCase, String word) {
        getPluralCases().put(wordCase, word);
    }


    public Map<Declension.Case, String> getCasesByForm(Declension.Form form)      { return forms.get(form); }

    public void setForm(Declension.Form form, Map<Declension.Case, String> cases) { forms.put(form, cases); }

    public Map<Declension.Case, String> getSingularCases() {
        return initOrGetCasesByForm(
                Declension.Form.SINGULAR);
    }

    public Map<Declension.Case, String> getPluralCases() {
        return initOrGetCasesByForm(
                Declension.Form.PLURAL);
    }

    public Map<Declension.Case, String> initOrGetCasesByForm(Declension.Form form) {
        Map<Declension.Case, String> result = getCasesByForm(form);
        if (result == null) {
            result = new HashMap<Declension.Case, String>() {{
                put(Declension.Case.NOMINATIVE, "");
                put(Declension.Case.GENITIVE, "");
            }};
            setForm(form, result);
        }
        return result;
    }

    public Map<Declension.Form, Map<Declension.Case, String>> getForms()           { return forms; }

    public void setForms(Map<Declension.Form, Map<Declension.Case, String>> forms) { this.forms = forms; }

    public String getRoot()                                                        {return root; }

    public void setRoot(String root)                                               {this.root = root; }

}
