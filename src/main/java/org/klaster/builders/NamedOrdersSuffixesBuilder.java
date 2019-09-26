package org.klaster.builders;

import org.klaster.models.NamedOrder;
import org.klaster.models.Suffix;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class NamedOrdersSuffixesBuilder {
    private NamedOrder.Gender currentGender;
    private NamedOrder.Form   currentForm;
    private NamedOrder.Case   currentCase;

    private List<Suffix> suffixes = new LinkedList<Suffix>() {{
        add(new Suffix(NamedOrder.Gender.MASCULINE, NamedOrder.Form.SINGULAR, NamedOrder.Case.NOMINATIVE, ""));
        add(new Suffix(NamedOrder.Gender.MASCULINE, NamedOrder.Form.SINGULAR, NamedOrder.Case.GENITIVE, "а"));
        add(new Suffix(NamedOrder.Gender.MASCULINE, NamedOrder.Form.PLURAL, NamedOrder.Case.NOMINATIVE, "ы"));
        add(new Suffix(NamedOrder.Gender.MASCULINE, NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE, "ов"));
        add(new Suffix(NamedOrder.Gender.FEMININE, NamedOrder.Form.SINGULAR, NamedOrder.Case.NOMINATIVE, "а"));
        add(new Suffix(NamedOrder.Gender.FEMININE, NamedOrder.Form.SINGULAR, NamedOrder.Case.GENITIVE, "и"));
        add(new Suffix(NamedOrder.Gender.FEMININE, NamedOrder.Form.PLURAL, NamedOrder.Case.NOMINATIVE, "и"));
        add(new Suffix(NamedOrder.Gender.FEMININE, NamedOrder.Form.PLURAL, NamedOrder.Case.GENITIVE, ""));
    }};

    public NamedOrdersSuffixesBuilder() {
        reset();
    }

    public NamedOrdersSuffixesBuilder withGender(NamedOrder.Gender currentGender) {
        this.currentGender = currentGender;
        return this;
    }

    public NamedOrdersSuffixesBuilder withForm(NamedOrder.Form currentForm) {
        this.currentForm = currentForm;
        return this;
    }

    public NamedOrdersSuffixesBuilder withCase(NamedOrder.Case currentCase) {
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
        this.currentForm   = NamedOrder.Form.SINGULAR;
        this.currentGender = NamedOrder.Gender.MASCULINE;
        this.currentCase   = NamedOrder.Case.NOMINATIVE;
    }

}
