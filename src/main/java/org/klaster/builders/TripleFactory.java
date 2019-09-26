package org.klaster.builders;

import org.klaster.models.Digit;
import org.klaster.models.Triple;
import org.klaster.services.DigitsRepository;

/**
 * @author Nikita Lepesevich <lepesevich.nikita@yandex.ru> on 9/26/19
 * @project testtask
 */
public class TripleFactory {
    private TripleBuilder    tripleBuilder;
    private DigitsRepository digitsRepository;
    private String           source;

    public TripleBuilder getTripleBuilder() {
        return tripleBuilder;
    }

    public void setTripleBuilder(TripleBuilder tripleBuilder) {
        this.tripleBuilder = tripleBuilder;
    }

    public Triple createTriple() {
        int sourceLength = source.length();
        assert (sourceLength <= 3);
        assert (tripleBuilder != null);
        if (!isEmptyNumber()) {
            if (isZeroNumber()) { addZeroToTripleBuilder(); }
            else {
                for (int i = 0; i < sourceLength; i++) {
                    char currentChar = source.charAt(i);
                    if (isTeens(i, currentChar)) {
                        addTeensToTripleBuilder();
                        break;
                    }
                    else { addDigitsToBuilderByPositionInTripleAndSymbol(currentChar, i); }
                }
            }
        }
        Triple result = tripleBuilder.getResult();
        return result;
    }

    private void addDigitsToBuilderByPositionInTripleAndSymbol(String symbol, int positionInTriple) {
        Digit digit = digitsRepository.getDigitByPositionInTripleAndSymbol(symbol, positionInTriple);
        if (digit != null) tripleBuilder.withDigits(digit);
    }

    private void addDigitsToBuilderByPositionInTripleAndSymbol(char symbol, int positionInTriple) {
        String symbolAsString = String.valueOf(symbol);
        addDigitsToBuilderByPositionInTripleAndSymbol(symbolAsString, positionInTriple);
    }

    private void addZeroToTripleBuilder() {
        addDigitsToBuilderByPositionInTripleAndSymbol("0", 0);
    }


    private void addTeensToTripleBuilder() {
        int sourceLength = source.length();
        addDigitsToBuilderByPositionInTripleAndSymbol(source.substring(sourceLength - 2, sourceLength), 1);
    }

    private boolean isEmptyNumber() {
        boolean result = source.isEmpty();
        result |= source.equals("000") || source.equals("00");
        return result;
    }

    private boolean isZeroNumber() {
        boolean result = source.equals("0");
        return result;
    }

    private boolean isTeens(int pos, char symbol) {
        int sourceLength = source.length();
        boolean result = symbol == '1';
        result &= sourceLength > 1;
        result &= pos == sourceLength - 2;
        return result;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDigitsRepository(DigitsRepository digitsRepository) {
        this.digitsRepository = digitsRepository;
    }
}
