package org.klaster.representers;

import org.klaster.builders.DefaultDigitAsStringRepresenterBuilder;
import org.klaster.builders.DefaultNamedOrdersAsStringRepresenterBuilder;
import org.klaster.builders.DefaultTripleBuilder;
import org.klaster.interfaces.DigitAsStringRepresenter;
import org.klaster.interfaces.DigitRepresenter;
import org.klaster.interfaces.NamedOrdersAsStringRepresenter;
import org.klaster.interfaces.TripleAsStringRepresenter;
import org.klaster.models.Triple;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/27/19
 * @project testtask
 */
public class DefaultTripleAsStringRepresenter implements TripleAsStringRepresenter {
    private DigitAsStringRepresenter       digitAsStringRepresenter;
    private NamedOrdersAsStringRepresenter namedOrdersAsStringRepresenter;
    private Triple                         triple;

    @Override
    public DigitRepresenter getDigitAsStringRepresenter() {
        return digitAsStringRepresenter;
    }

    @Override
    public TripleAsStringRepresenter withDigitsGenderFormsBuilder(DigitAsStringRepresenter digitAsStringRepresenter) {
        this.digitAsStringRepresenter = digitAsStringRepresenter;
        return this;
    }

    @Override
    public TripleAsStringRepresenter withNamedOrdersFormsBuilder(NamedOrdersAsStringRepresenter namedOrdersFormsRepresenter) {
        this.namedOrdersAsStringRepresenter = namedOrdersFormsRepresenter;
        return this;
    }

    @Override
    public String from(Triple sourceTriple) {
        this.triple = sourceTriple;
        return getResult();
    }

    private String getResult() {
        assert (triple != null);
        assert (digitAsStringRepresenter != null);
        assert (namedOrdersAsStringRepresenter != null);
        digitAsStringRepresenter.reset();
        namedOrdersAsStringRepresenter.reset();
        String result = "";
        if (!triple.isEmpty()) {
            List<String> words = getCorrectFormOfDigits();
            words.add(getNamedOrderInCorrectForm());
            result = String.join(" ", words).trim();
        }
        return result;
    }

    @Override
    public void reset() {
        namedOrdersAsStringRepresenter = new DefaultNamedOrdersAsStringRepresenterBuilder().getResult();
        digitAsStringRepresenter       = new DefaultDigitAsStringRepresenterBuilder().getResult();
        triple                         = new DefaultTripleBuilder().getResult();
    }

    private List<String> getCorrectFormOfDigits() {
        List<String> result = triple.getDigits()
                                    .stream()
                                    .map(d -> digitAsStringRepresenter.withGender(triple.getGender()).from(d))
                                    .collect(Collectors.toList());
        return result;
    }

    private String getNamedOrderInCorrectForm() {
        String result = namedOrdersAsStringRepresenter.withForm(triple.getForm())
                                                      .withCase(triple.getCase())
                                                      .from(triple.getNamedOrder());
        return result;
    }
}
