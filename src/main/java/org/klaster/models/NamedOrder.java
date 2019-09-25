package org.klaster.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class NamedOrder {
    private Map<Form, Map<Case, String>> forms;
    private Gender                       gender;
    private int                          namedOrderNumber;
    private String                       root;

    public NamedOrder() {
        this.gender = Gender.MASCULINE;
        this.forms  = new HashMap<Form, Map<Case, String>>();
    }

    public Gender getGender()                               { return gender; }

    public void setGender(Gender gender)                    { this.gender = gender; }


    public int getNamedOrderNumber()                        { return namedOrderNumber; }

    public void setNamedOrderNumber(int namedOrderNumber)   { this.namedOrderNumber = namedOrderNumber; }


    public String getSingular(Case wordCase)                { return getSingularCases().get(wordCase); }

    public void setSingular(Case wordCase, String word)     { getSingularCases().put(wordCase, word); }

    public String getPlural(Case wordCase)                  {return getPluralCases().get(wordCase);}

    public void setPlural(Case wordCase, String word)       { getPluralCases().put(wordCase, word); }


    public Map<Case, String> getCasesByForm(Form form)      { return forms.get(form); }

    public void setForm(Form form, Map<Case, String> cases) { forms.put(form, cases); }

    public Map<Case, String> getSingularCases()             { return initOrGetCasesByForm(Form.SINGULAR); }

    public Map<Case, String> getPluralCases()               { return initOrGetCasesByForm(Form.PLURAL); }

    public Map<Case, String> initOrGetCasesByForm(Form form) {
        Map<Case, String> result = getCasesByForm(form);
        if (result == null) {
            result = new HashMap<Case, String>() {{
                put(Case.NOMINATIVE, "");
                put(Case.GENITIVE, "");
            }};
            setForm(form, result);
        }
        return result;
    }

    public Map<Form, Map<Case, String>> getForms()           { return forms; }

    public void setForms(Map<Form, Map<Case, String>> forms) { this.forms = forms; }

    public String getRoot()                                  {return root; }

    public void setRoot(String root)                         {this.root = root; }

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
