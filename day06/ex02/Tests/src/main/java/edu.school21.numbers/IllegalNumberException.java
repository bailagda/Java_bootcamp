package edu.school21.numbers;

public class IllegalNumberException extends Throwable {
    @Override
    public String toString() {
        return "Number is wrong";
    }
}
