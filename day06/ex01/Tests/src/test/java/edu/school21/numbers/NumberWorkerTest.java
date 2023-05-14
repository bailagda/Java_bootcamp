package edu.school21.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberWorkerTest {
    NumberWorker nw;
    @BeforeEach
    void setUp() {
        nw = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5,7,11,13,17})
    void isPrimeForPrimes(int number) throws IllegalNumberException {
        assertTrue(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4,6,8,10,12,15})
    void isPrimeForNotPrimes(int num) throws IllegalNumberException {
        assertFalse(nw.isPrime((num)));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 1, -200})
    void isPrimeForIncorrectNumbers(int num) throws IllegalNumberException {
        IllegalNumberException trown = assertThrows(IllegalNumberException.class, () -> {
            nw.isPrime(num);
        });
        assertEquals(trown.toString(), "Number is wrong");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void isDigitSumCorrect(int num, int result) {
        assertEquals(nw.digitsSum(num), result);
    }
}

