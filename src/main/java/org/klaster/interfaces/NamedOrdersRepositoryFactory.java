package org.klaster.interfaces;

import org.klaster.services.DefaultNamedOrdersRepository;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface NamedOrdersRepositoryFactory extends RepositoryFactory<NamedOrdersRepository> {

    @Override
    default Class<?> getRepositoryClass() {
        return DefaultNamedOrdersRepository.class;
    }
}
