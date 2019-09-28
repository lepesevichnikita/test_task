package org.klaster.services;

import org.klaster.models.NamedOrder;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class NamedOrdersRepository {
    private        List<NamedOrder> namedOrders;
    static private String           dictionaryName = "named_orders.yaml";

    public static NamedOrdersRepository loadRepository() {
        Constructor ctr = new Constructor(NamedOrdersRepository.class);
        Yaml yaml = new Yaml(ctr);
        InputStream inputStream = NamedOrdersRepository.class
                .getClassLoader()
                .getResourceAsStream(dictionaryName);
        NamedOrdersRepository result = yaml.load(inputStream);
        return result;
    }

    public List<NamedOrder> getNamedOrders()                 {return namedOrders; }

    public void setNamedOrders(List<NamedOrder> namedOrders) { this.namedOrders = namedOrders; }

    public NamedOrder getByNumber(int namedOrderNumber) {
        NamedOrder result =
                namedOrders.parallelStream()
                           .filter(no -> no.getNumber() == namedOrderNumber)
                           .findFirst()
                           .orElse(null);
        return result;
    }
}
