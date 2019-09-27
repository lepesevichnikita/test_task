package org.klaster.services;

import org.klaster.builders.DigitsGenderFormsBuilder;
import org.klaster.builders.NamedOrdersFormsBuilder;
import org.klaster.models.Triple;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/27/19
 * @project testtask
 */
public class TripleAsWordsRepresenter {
    private DigitsGenderFormsBuilder digitsGenderFormsBuilder;
    private NamedOrdersFormsBuilder  namedOrdersFormsBuilder;
    private Triple                   triple;

    public DigitsGenderFormsBuilder getDigitsGenderFormsBuilder() {
        return digitsGenderFormsBuilder;
    }

    public void setDigitsGenderFormsBuilder(DigitsGenderFormsBuilder digitsGenderFormsBuilder) {
        this.digitsGenderFormsBuilder = digitsGenderFormsBuilder;
    }

    public NamedOrdersFormsBuilder getNamedOrdersFormsBuilder() {
        return namedOrdersFormsBuilder;
    }

    public void setNamedOrdersFormsBuilder(NamedOrdersFormsBuilder namedOrdersFormsBuilder) {
        this.namedOrdersFormsBuilder = namedOrdersFormsBuilder;
    }

    public Triple getTriple() {
        return triple;
    }

    public void setTriple(Triple triple) {
        this.triple = triple;
    }

    public String asString() {
        assert (triple != null);
        assert (digitsGenderFormsBuilder != null);
        assert (namedOrdersFormsBuilder != null);
        digitsGenderFormsBuilder.reset();
        namedOrdersFormsBuilder.reset();
        List<String> words = getCorrectFormOfDigits();
        words.add(getNamedOrderInCorrectForm());
        String result = String.join(" ", words).trim();
        return result;
    }

    private List<String> getCorrectFormOfDigits() {
        List<String> result = triple.getDigits()
                                    .parallelStream()
                                    .map(d -> digitsGenderFormsBuilder.withDigit(d)
                                                                      .withGender(triple.getGender())
                                                                      .getResult())
                                    .collect(Collectors.toList());
        return result;
    }

    private String getNamedOrderInCorrectForm() {
        String result = namedOrdersFormsBuilder.withNamedOrder(triple.getNamedOrder())
                                               .withForm(triple.getForm())
                                               .withCase(triple.getCase())
                                               .getResult();
        return result;
    }
}
