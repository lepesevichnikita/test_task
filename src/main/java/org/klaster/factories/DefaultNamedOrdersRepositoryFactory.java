package org.klaster.factories;

import org.klaster.interfaces.NamedOrdersRepositoryFactory;
import org.klaster.services.DefaultNamedOrdersRepository;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultNamedOrdersRepositoryFactory implements NamedOrdersRepositoryFactory {
    @Override
    public String getDictionaryName() {
        return "named_orders.yaml";
    }

    @Override
    public Class getRepositoryClass() {
        return DefaultNamedOrdersRepository.class;
    }
}
