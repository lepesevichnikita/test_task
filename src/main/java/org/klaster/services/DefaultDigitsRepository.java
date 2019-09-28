package org.klaster.services;

import org.klaster.interfaces.DigitsRepository;
import org.klaster.models.Digit;

import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DefaultDigitsRepository implements DigitsRepository {
    private List<Digit> items;

    @Override
    public List<Digit> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Digit> items) {
        this.items = items;
    }

    public Digit getDigitByPositionInTripleAndSymbol(String symbol, int positionInTriple) {
        Digit result =
                items.parallelStream()
                     .filter(d -> d.getSymbol().equals(symbol) && d.getPositionInTriple() == positionInTriple)
                     .findFirst()
                     .orElse(null);
        return result;
    }

}
