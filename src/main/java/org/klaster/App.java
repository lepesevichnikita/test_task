package org.klaster;

import org.klaster.builders.DefaultTripleSequenceAsStringRepresenterBuilder;
import org.klaster.builders.DefaultTripleSequenceFactoryBuilder;
import org.klaster.interfaces.TripleSequenceAsStringRepresenter;
import org.klaster.interfaces.TripleSequenceFactory;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class App
{
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        TripleSequenceFactory tripleSequenceFactory = new DefaultTripleSequenceFactoryBuilder().getResult();
        TripleSequenceAsStringRepresenter tripleSequenceAsStringRepresenter =
                new DefaultTripleSequenceAsStringRepresenterBuilder().getResult();

        List<Boolean> testsResult = new LinkedList<>();
        List<String> input = new LinkedList<>();
        List<String> actual = new LinkedList<>();
        List<String> expected = new LinkedList<>();
        System.out.flush();
        int testsCount = Integer.valueOf(System.console().readLine("Введите число тестов: "));
        IntStream.range(0, testsCount).forEach(dataSetNumber -> {
            String number = System.console().readLine(" Введите число в цифровом виде: ");
            String expectedWordsRepresentationOfNumber = System.console()
                                                               .readLine(
                                                                       " Введите строковое представление этого " +
                                                                               "числа: ");

            tripleSequenceFactory.setSource(number);

            String actualWordsRepresentationOfNumber =
                    tripleSequenceAsStringRepresenter.from(tripleSequenceFactory.create());
            expected.add(expectedWordsRepresentationOfNumber);

            input.add(number);
            actual.add(actualWordsRepresentationOfNumber);
            testsResult.add(actualWordsRepresentationOfNumber.equals(expectedWordsRepresentationOfNumber));
        });
        System.out.flush();
        IntStream.range(0, testsCount).forEach(dataSetNumber -> {
            boolean testResult = testsResult.get(dataSetNumber);
            printStream.println(String.format("Тест #%d результат: %s",
                                              dataSetNumber,
                                              testResult ? "успешно завершен" : "провален"));
            if (!testResult) {
                printStream.println(String.format("\tИсходное число: %s", input.get(dataSetNumber)));
                printStream.println(String.format("\tОжидаемый результат: %s", expected.get(dataSetNumber)));
                printStream.println(String.format("\tРеальный результат: %s", actual.get(dataSetNumber)));
            }
        });
    }
}

