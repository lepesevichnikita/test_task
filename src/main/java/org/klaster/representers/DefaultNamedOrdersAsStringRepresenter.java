package org.klaster.representers;

import org.klaster.builders.DefaultDeclensionBuilder;
import org.klaster.interfaces.NamedOrdersAsStringRepresenter;
import org.klaster.interfaces.SuffixesRepository;
import org.klaster.models.Declension;
import org.klaster.models.NamedOrder;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DefaultNamedOrdersAsStringRepresenter implements NamedOrdersAsStringRepresenter {
    private Declension.Form    form;
    private Declension.Case    aCase;
    private NamedOrder         namedOrder;
    private SuffixesRepository suffixesRepository;

    @Override
    public NamedOrdersAsStringRepresenter withSuffixesRepository(SuffixesRepository suffixesRepository) {
        this.suffixesRepository = suffixesRepository;
        return this;
    }

    @Override
    public NamedOrdersAsStringRepresenter withForm(Declension.Form requiredForm) {
        this.form = requiredForm;
        return this;
    }

    @Override
    public NamedOrdersAsStringRepresenter withCase(Declension.Case requiredCase) {
        this.aCase = requiredCase;
        return this;
    }


    @Override
    public String from(NamedOrder source) {
        namedOrder = source;
        return getResult();
    }

    @Override
    public void reset() {
        form  = Declension.Form.SINGULAR;
        aCase = Declension.Case.NOMINATIVE;
    }

    private String getResult() {
        String result = namedOrder.initOrGetCasesByForm(form).get(aCase);
        if (result.isEmpty() && !namedOrder.getRoot().isEmpty()) {
            Declension declension =
                    new DefaultDeclensionBuilder().withCase(aCase)
                                                  .withForm(form)
                                                  .withGender(namedOrder.getGender())
                                                  .getResult();
            result = namedOrder.getRoot();
            result += suffixesRepository.getSuffixByDeclension(declension).getValue();
        }
        return result;
    }

    public SuffixesRepository getSuffixesRepository() { return this.suffixesRepository; }

    public void setSuffixesRepository(SuffixesRepository suffixesRepository) {
        this.suffixesRepository = suffixesRepository;
    }
}
