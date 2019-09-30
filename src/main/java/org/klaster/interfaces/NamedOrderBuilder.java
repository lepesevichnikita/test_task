package org.klaster.interfaces;

import org.klaster.models.Declension;
import org.klaster.models.NamedOrder;

import java.util.Map;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public interface NamedOrderBuilder extends Builder<NamedOrder> {
    NamedOrderBuilder withForms(Map<Declension.Form, Map<Declension.Case, String>> forms);

    NamedOrderBuilder withGender(Declension.Gender gender);

    NamedOrderBuilder withNumber(int number);

    NamedOrderBuilder withRoot(String root);
}
