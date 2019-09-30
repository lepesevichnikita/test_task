package org.klaster.builders;

import org.klaster.factories.DefaultSuffixesRepositoryFactory;
import org.klaster.interfaces.NamedOrdersAsStringRepresenter;
import org.klaster.interfaces.NamedOrdersAsStringRepresenterBuilder;
import org.klaster.interfaces.NamedOrdersRepresenterBuilder;
import org.klaster.interfaces.SuffixesRepository;
import org.klaster.models.Declension;
import org.klaster.representers.DefaultNamedOrdersAsStringRepresenter;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public class DefaultNamedOrdersAsStringRepresenterBuilder implements NamedOrdersAsStringRepresenterBuilder {
    private Declension.Form    form;
    private Declension.Case    aCase;
    private SuffixesRepository suffixesRepository;

    public DefaultNamedOrdersAsStringRepresenterBuilder() { reset(); }

    @Override
    public NamedOrdersRepresenterBuilder withForm(Declension.Form form) {
        this.form = form;
        return this;
    }

    @Override
    public NamedOrdersRepresenterBuilder withCase(Declension.Case aCase) {
        this.aCase = aCase;
        return this;
    }

    @Override
    public NamedOrdersRepresenterBuilder withSuffixesRepository(SuffixesRepository suffixesRepository) {
        this.suffixesRepository = suffixesRepository;
        return this;
    }

    @Override
    public NamedOrdersAsStringRepresenter getResult() {
        NamedOrdersAsStringRepresenter result = new DefaultNamedOrdersAsStringRepresenter();
        return result.withCase(aCase).withForm(form).withSuffixesRepository(suffixesRepository);
    }

    @Override
    public void reset() {
        aCase              = Declension.Case.NOMINATIVE;
        form               = Declension.Form.SINGULAR;
        suffixesRepository = new DefaultSuffixesRepositoryFactory().create();
    }
}
