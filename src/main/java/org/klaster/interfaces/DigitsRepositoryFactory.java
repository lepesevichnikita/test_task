package org.klaster.interfaces;

import org.klaster.services.DefaultDigitsRepository;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface DigitsRepositoryFactory extends RepositoryFactory<DigitsRepository> {

    @Override
    default Class<?> getRepositoryClass() {
        return DefaultDigitsRepository.class;
    }
}
