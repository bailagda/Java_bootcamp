package edu.school21.numbers;

public class prog {
    public static void main(String[] args) throws IllegalNumberException {
        NumberWorker nw = new NumberWorker();
        System.out.println(nw.isPrime(7));
        System.out.println(nw.digitsSum( 993));
    }
}
