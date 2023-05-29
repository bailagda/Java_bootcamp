package edu.school21.numbers;

import static java.lang.Math.sqrt;

public class NumberWorker {
    public boolean isPrime(int number) throws IllegalNumberException {
        if (number <= 1) {
            throw new IllegalNumberException();
        }
        int i = 2;
        while (i <= sqrt(number)) {
            if (number % i == 0) {
               return false;
            }
            ++i;
        }
        return true;
    }

    public int digitsSum(int number) {
        int sum = 0;
        while(number/10 > 0) {
            sum += number%10;
            number/=10;
        }
        sum+= number;
        return sum;
    }
}
