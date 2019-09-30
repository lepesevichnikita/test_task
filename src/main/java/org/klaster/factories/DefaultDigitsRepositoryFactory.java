package org.klaster.factories;

import org.klaster.interfaces.DigitsRepositoryFactory;
import org.klaster.services.DefaultDigitsRepository;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultDigitsRepositoryFactory implements DigitsRepositoryFactory {

    @Override
    public String getDictionaryName() {
        return "digits.yaml";
    }

    @Override
    public Class getRepositoryClass() {
        return DefaultDigitsRepository.class;
    }
}
