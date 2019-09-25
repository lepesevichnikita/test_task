package org.klaster.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class NamedOrder {
    private Map<Form, Map<Case, String>> forms = new HashMap<Form, Map<Case, String>>() {{
        put(Form.SINGULAR, new HashMap<Case, String>() {{
            put(Case.NOMINATIVE, "");
            put(Case.GENITIVE, "");
        }});
        put(Form.PLURAL, new HashMap<Case, String>() {{
            put(Case.NOMINATIVE, "");
            put(Case.GENITIVE, "");
        }});
    }};
    private Case                         currentCase;
    private Form                         currentForm;
    private Gender                       requiredDigitsGender;
    private int                          namedOrderNumber;

    public NamedOrder() {
        this.requiredDigitsGender = Gender.MASCULINE;
        this.currentForm          = Form.SINGULAR;
        this.currentCase          = Case.NOMINATIVE;
    }

    public Gender getRequiredDigitsGender() {
        return requiredDigitsGender;
    }

    public void setRequiredDigitsGender(Gender requiredDigitsGender) {
        this.requiredDigitsGender = requiredDigitsGender;
    }

    public Form getCurrentForm() {
        return currentForm;
    }

    public void setCurrentForm(Form currentForm) {
        this.currentForm = currentForm;
    }

    public Case getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(Case currentCase) {
        this.currentCase = currentCase;
    }

    public int getNamedOrderNumber() {
        return namedOrderNumber;
    }

    public void setNamedOrderNumber(int namedOrderNumber) {
        this.namedOrderNumber = namedOrderNumber;
    }

    public void setSingular(Case wordCase, String word) {
        getSingular().put(wordCase, word);
    }

    public void setPlural(Case wordCase, String word) {
        getPlural().put(wordCase, word);
    }

    public String getSingular(Case wordCase) {
        return getSingular().get(wordCase);
    }

    public String getPlural(Case wordCase) {
        return getPlural().get(wordCase);
    }

    public Map<Case, String> getSingular() {
        return this.forms.get(Form.SINGULAR);
    }

    public Map<Case, String> getPlural() {
        return this.forms.get(Form.PLURAL);
    }

    public Map<Form, Map<Case, String>> getForms()           { return forms; }

    public void setForms(Map<Form, Map<Case, String>> forms) { this.forms = forms; }

    public String toString() {
        return this.forms.get(currentForm).get(currentCase);
    }

    public enum Form {
        PLURAL, SINGULAR
    }
    public enum Gender {
        MASCULINE, FEMININE, NEUTER
    }
    public enum Case {
        NOMINATIVE, GENITIVE
    }

}
