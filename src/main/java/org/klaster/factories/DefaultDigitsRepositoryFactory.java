package org.klaster.factories;

import org.klaster.interfaces.DigitsRepositoryFactory;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public class DefaultDigitsRepositoryFactory implements DigitsRepositoryFactory {
    @Override
    public String getDictionaryName() {
        return "digits.yaml";
    }
}
