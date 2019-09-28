package org.klaster.builders;

import org.klaster.interfaces.DeclensionsBuilder;
import org.klaster.models.Declension;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultDeclensionBuilder implements DeclensionsBuilder {
    private Declension        result;
    private Declension.Case   aCase;
    private Declension.Form   form;
    private Declension.Gender gender;

    public DefaultDeclensionBuilder() { reset(); }

    @Override
    public DeclensionsBuilder withCase(Declension.Case aCase) {
        this.aCase = aCase;
        return this;
    }

    @Override
    public DeclensionsBuilder withForm(Declension.Form form) {
        this.form = form;
        return this;
    }

    @Override
    public DeclensionsBuilder withGender(Declension.Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public Declension getResult() {
        result.setCase(aCase);
        result.setForm(form);
        result.setGender(gender);
        return result;
    }

    @Override
    public void reset() {
        result = new Declension();
        aCase  = Declension.Case.GENITIVE;
        form   = Declension.Form.PLURAL;
        gender = Declension.Gender.MASCULINE;
    }
}
