package ex02;

import java.util.Arrays;
import java.util.FormatterClosedException;
import java.util.Random;

import static java.lang.Math.random;
public class Thread_02 {
    static Random rand = new Random();
    static int threadsCount;
    static int arrSize;
    static int sumOfThreads = 0;
    public static void main(String[] args) throws InterruptedException {
        for (String i:
              args) {
            if(i.contains("--arraySize=")){
                String[] s = i.split("=");
                arrSize =Integer.parseInt(s[1]);
            }
            if(i.contains("--threadsCount=")){
                String[] s = i.split("=");
                threadsCount =Integer.parseInt(s[1]);
            }
        }
        MyThread[] arrTreads = new MyThread[threadsCount];

        int[] arr = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = rand.nextInt(30);
//            System.out.println(arr[i]);
        }
        int countForThread = arrSize/(threadsCount-1);

        printSum(arr);
        int lastElem = 0;
        for (int i = 0; i < threadsCount; i++) {
            int[] partOfArr = new int[countForThread];
            int start = 0;
            try {
                for (; start < countForThread; start++) {
                    partOfArr[start] = arr[lastElem + start];
                }
            } catch (IndexOutOfBoundsException ignored) {}
            arrTreads[i] = new MyThread("Thread "+Integer.toString(i),
                    partOfArr, lastElem, lastElem+start);
            arrTreads[i].start();
            lastElem += start;
        }
        for (MyThread t:
             arrTreads) {
            t.join();
            sumOfThreads += t.getSum();
        }

        System.out.printf("Sum by threads: %d", sumOfThreads);
    }

    static private void printSum(int[] arr) {
        System.out.printf("Sum: %d\n", Arrays.stream(arr).sum());
    }

    public static class MyThread extends Thread {
        private final int[] arr;
        private int sum = 0;
        private int start = 0;
        private int finish = 0;

        public synchronized int getSum() {
            return sum;
        }
        MyThread(String name, int[] arr, int start, int finish){
            super(name);
            this.arr = arr;
            this.start = start;
            this.finish = finish;
        }
        @Override
        public void run() {
            sum = Arrays.stream(arr).sum();
            try {
                print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized public void print() throws InterruptedException {
            System.out.printf("%s: from %d to %d sum is %d\n",
                    Thread.currentThread().getName(), start, finish, sum);
        }
    }
}
