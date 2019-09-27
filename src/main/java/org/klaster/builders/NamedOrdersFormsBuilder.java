package org.klaster.builders;

import org.klaster.models.NamedOrder;
/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class NamedOrdersFormsBuilder {
    private NamedOrder.Form            form;
    private NamedOrder.Case            aCase;
    private NamedOrder                 namedOrder;
    private NamedOrdersSuffixesBuilder namedOrdersSuffixesBuilder;

    public NamedOrdersFormsBuilder() {
        reset();
    }

    public NamedOrdersFormsBuilder withNamedOrder(NamedOrder namedOrder) {
        this.namedOrder = namedOrder;
        return this;
    }

    public NamedOrdersFormsBuilder withForm(NamedOrder.Form requiredForm) {
        this.form = requiredForm;
        return this;
    }

    public NamedOrdersFormsBuilder withCase(NamedOrder.Case requiredCase) {
        this.aCase = requiredCase;
        return this;
    }

    public String getResult() {
        assert (namedOrder != null);
        String result = namedOrder.initOrGetCasesByForm(form).get(aCase);
        if (result.isEmpty() && !namedOrder.getRoot().isEmpty()) {
            result = namedOrder.getRoot();
            result += namedOrdersSuffixesBuilder.withGender(namedOrder.getGender())
                                                .withForm(form)
                                                .withCase(aCase)
                                                .getResult();
        }
        return result;
    }

    public void reset() {
        form                       = NamedOrder.Form.SINGULAR;
        aCase                      = NamedOrder.Case.NOMINATIVE;
        namedOrder                 = null;
        namedOrdersSuffixesBuilder = new NamedOrdersSuffixesBuilder();
    }
}
