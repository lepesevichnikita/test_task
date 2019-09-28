package org.klaster.factories;

import org.klaster.interfaces.NamedOrdersRepositoryFactory;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultNamedOrdersRepositoryFactory implements NamedOrdersRepositoryFactory {
    @Override
    public String getDictionaryName() {
        return "named_orders.yaml";
    }
}
