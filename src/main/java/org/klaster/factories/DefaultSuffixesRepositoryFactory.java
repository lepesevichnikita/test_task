package org.klaster.factories;

import org.klaster.interfaces.SuffixesRepositoryFactory;
import org.klaster.services.DefaultSuffixesRepository;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/29/19
 * @project testtask
 */
public class DefaultSuffixesRepositoryFactory implements SuffixesRepositoryFactory {
    @Override
    public String getDictionaryName() {
        return "suffixes.yaml";
    }

    @Override
    public Class getRepositoryClass() {
        return DefaultSuffixesRepository.class;
    }
}
