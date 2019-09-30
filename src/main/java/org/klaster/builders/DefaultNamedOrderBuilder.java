package org.klaster.builders;

import org.klaster.interfaces.NamedOrderBuilder;
import org.klaster.models.Declension;
import org.klaster.models.NamedOrder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public class DefaultNamedOrderBuilder implements NamedOrderBuilder {
    private Map<Declension.Form, Map<Declension.Case, String>> forms;
    private Declension.Gender                                  gender;
    private int                                                number;
    private String                                             root;

    @Override
    public NamedOrderBuilder withForms(Map<Declension.Form, Map<Declension.Case, String>> forms) {
        this.forms = forms;
        return this;
    }

    @Override
    public NamedOrderBuilder withGender(Declension.Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public NamedOrderBuilder withNumber(int number) {
        this.number = number;
        return this;
    }

    @Override
    public NamedOrderBuilder withRoot(String root) {
        this.root = root;
        return this;
    }

    @Override
    public NamedOrder getResult() {
        NamedOrder result = new NamedOrder();
        result.setGender(gender);
        result.setForms(forms);
        result.setRoot(root);
        result.setNumber(number);
        return result;
    }

    @Override
    public void reset() {
        forms  = new HashMap<>();
        gender = Declension.Gender.MASCULINE;
        number = 0;
        root   = "";
    }
}
