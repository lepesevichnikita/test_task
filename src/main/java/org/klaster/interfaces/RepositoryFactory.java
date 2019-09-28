package org.klaster.interfaces;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/28/19
 * @project testtask
 */
public interface RepositoryFactory<T> {
    String getDictionaryName();

    Class<?> getRepositoryClass();

    default T loadRepository() {
        Constructor ctr = new Constructor(getRepositoryClass());
        Yaml yaml = new Yaml(ctr);
        InputStream inputStream = getRepositoryClass()
                .getClassLoader()
                .getResourceAsStream(getDictionaryName());
        T result = yaml.load(inputStream);
        return result;
    }
}
