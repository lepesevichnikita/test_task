package org.klaster.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/24/19
 * @project testtask
 */
public class NamedOrder {
    private final Map<Form, Map<Case, String>> forms = new HashMap<Form, Map<Case, String>>() {{
        put(Form.SINGULAR, new HashMap<Case, String>() {{
            put(Case.NOMINATIVE, "");
            put(Case.GENITIVE, "");
        }});
        put(Form.PLURAL, new HashMap<Case, String>() {{
            put(Case.NOMINATIVE, "");
            put(Case.GENITIVE, "");
        }});
    }};
    private Case   wordCase;
    private Form   wordForm;
    private Gender wordGender;
    private int    namedOrderNumber;

    public NamedOrder() {
        this.wordForm = Form.SINGULAR;
        this.wordCase = Case.NOMINATIVE;
    }

    public Gender getWordGender() {
        return wordGender;
    }

    public void setWordGender(Gender wordGender) {
        this.wordGender = wordGender;
    }

    public Form getWordForm() {
        return wordForm;
    }

    public void setWordForm(Form wordForm) {
        this.wordForm = wordForm;
    }

    public Case getWordCase() {
        return wordCase;
    }

    public void setWordCase(Case wordCase) {
        this.wordCase = wordCase;
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

    public String toString() {
        return this.forms.get(wordForm).get(wordCase);
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
