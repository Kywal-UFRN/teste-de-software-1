package br.ufrn.imd.listas.exercicios02.questao12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAverage {

    @ParameterizedTest
    @MethodSource("intProvider")
    public void testAverage(int num1, int num2, int num3, double expectedAverage) {
        double result = Average.semester(num1, num2, num3);
        assertEquals(expectedAverage, result);
    }

    static Stream<Arguments> intProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 2.0),
                Arguments.of(4, 5, 6, 5.0),
                Arguments.of(7, 8, 9, 7.0)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 2.0",
            "4, 5, 6, 5.0",
            "7, 8, 9, 8.0"
    })
    public void testAverageWithCsv(int num1, int num2, int num3, double expectedAverage) {
        double result = Average.semester(num1, num2, num3);
        assertEquals(expectedAverage, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testAverage.csv", numLinesToSkip = 1)
    public void testAverageWithCsvFile(int num1, int num2, int num3, double expectedAverage) {
        double result = Average.semester(num1, num2, num3);
        assertEquals(expectedAverage, result);
    }
}
