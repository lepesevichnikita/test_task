package org.klaster;

import org.klaster.builders.DefaultTripleSequenceAsWordsRepresenterBuilder;
import org.klaster.builders.DefaultTripleSequenceFactoryBuilder;
import org.klaster.factories.TripleSequenceFactory;
import org.klaster.services.TriplesSequenceAsWordsRepresenter;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class App
{
    public static void main( String[] args )
    {
        PrintStream printStream = System.out;
        TripleSequenceFactory tripleSequenceFactory = new DefaultTripleSequenceFactoryBuilder().getResult();
        TriplesSequenceAsWordsRepresenter triplesSequenceAsWordsRepresenter =
                new DefaultTripleSequenceAsWordsRepresenterBuilder().getResult();

        List<Boolean> testsResult = new LinkedList<>();
        List<String> actual = new LinkedList<>();
        List<String> expected = new LinkedList<>();
        int testsCount = Integer.valueOf(System.console().readLine("Введите число тестов: "));
        IntStream.range(0, testsCount).forEach(dataSetNumber -> {
            String number = System.console().readLine(" Введите число в цифровом виде: ");
            String expectedWordsRepresentationOfNumber = System.console()
                                                               .readLine(
                                                                       "\tВведите строковое представление этого " +
                                                                               "числа:");

            tripleSequenceFactory.setSource(number);
            triplesSequenceAsWordsRepresenter.setTripleSequence(tripleSequenceFactory.createTripleSequence());
            String actualWordsRepresentationOfNumber = triplesSequenceAsWordsRepresenter.asString();
            expected.add(expectedWordsRepresentationOfNumber);
            actual.add(actualWordsRepresentationOfNumber);
            testsResult.add(actualWordsRepresentationOfNumber.equals(expectedWordsRepresentationOfNumber));

        });

        IntStream.range(0, testsCount).forEach(dataSetNumber -> {
            boolean testResult = testsResult.get(dataSetNumber);
            printStream.println(String.format("Тест #%d результат: %s",
                                              dataSetNumber,
                                              testResult ? "успешно завершен" : "провален"));
            if (!testResult) {
                printStream.println(String.format("\tОжидаемый результат: %s", expected.get(dataSetNumber)));
                printStream.println(String.format("\t Реальный результат: %s", actual.get(dataSetNumber)));
            }
        });
    }
}

