package org.klaster.services;

import org.klaster.models.Digit;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.List;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/25/19
 * @project testtask
 */
public class DigitsRepository {
    private List<Digit> digits;


    public DigitsRepository() {
    }

    public List<Digit> getDigits() {
        return digits;
    }

    public void setDigits(List<Digit> digits) {
        this.digits = digits;
    }

    public Digit getDigitByPositionInTripleAndDigit(String symbol, int positionInTriple) {
        Digit result =
                digits.parallelStream()
                        .filter(d -> d.getSymbol().equals(symbol) && d.getPositionInTriple() == positionInTriple)
                        .findFirst()
                        .orElse(null);
        return result;
    }

    public static DigitsRepository loadRepository() {
        Constructor ctr = new Constructor(DigitsRepository.class);
        Yaml yaml = new Yaml(ctr);
        InputStream inputStream = DigitsRepository.class
                .getClassLoader()
                .getResourceAsStream("digits.yaml");
        DigitsRepository result = yaml.load(inputStream);
        return result;
    }
}
