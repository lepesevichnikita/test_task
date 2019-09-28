package org.klaster.builders;

import org.klaster.models.Declension;
import org.klaster.models.Suffix;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class NamedOrdersSuffixesBuilder {
    private Declension.Gender currentGender;
    private Declension.Form   currentForm;
    private Declension.Case   currentCase;

    private List<Suffix> suffixes = new LinkedList<Suffix>() {{
        add(new Suffix(Declension.Gender.MASCULINE, Declension.Form.SINGULAR, Declension.Case.NOMINATIVE, ""));
        add(new Suffix(Declension.Gender.MASCULINE, Declension.Form.SINGULAR, Declension.Case.GENITIVE, "а"));
        add(new Suffix(Declension.Gender.MASCULINE, Declension.Form.PLURAL, Declension.Case.NOMINATIVE, "ы"));
        add(new Suffix(Declension.Gender.MASCULINE, Declension.Form.PLURAL, Declension.Case.GENITIVE, "ов"));
        add(new Suffix(Declension.Gender.FEMININE, Declension.Form.SINGULAR, Declension.Case.NOMINATIVE, "а"));
        add(new Suffix(Declension.Gender.FEMININE, Declension.Form.SINGULAR, Declension.Case.GENITIVE, "и"));
        add(new Suffix(Declension.Gender.FEMININE, Declension.Form.PLURAL, Declension.Case.NOMINATIVE, "и"));
        add(new Suffix(Declension.Gender.FEMININE, Declension.Form.PLURAL, Declension.Case.GENITIVE, ""));
    }};

    public NamedOrdersSuffixesBuilder() {
        reset();
    }

    public NamedOrdersSuffixesBuilder withGender(Declension.Gender currentGender) {
        this.currentGender = currentGender;
        return this;
    }

    public NamedOrdersSuffixesBuilder withForm(Declension.Form currentForm) {
        this.currentForm = currentForm;
        return this;
    }

    public NamedOrdersSuffixesBuilder withCase(Declension.Case currentCase) {
        this.currentCase = currentCase;
        return this;
    }

    public String getResult() {
        String result = "";
        Suffix suffix =
                suffixes.stream()
                        .filter(sfx -> sfx.getCase() == currentCase && sfx.getForm() == currentForm && sfx.getGender() == currentGender)
                        .findFirst()
                        .orElse(null);
        if (suffix != null) result += suffix.getValue();
        return result;
    }

    public void reset() {
        this.currentForm   = Declension.Form.SINGULAR;
        this.currentGender = Declension.Gender.MASCULINE;
        this.currentCase   = Declension.Case.NOMINATIVE;
    }

}
