package ex02;

import static java.lang.Math.random;
public class Thread_02 {
    public static void main(String[] args) {
        int arrSize=13;
        int threadsCount=3;
        int[] arr;
        arr = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = (int) random();
        }
        
        String name = "Thread ";
        for (int i = 0; i < threadsCount; i++) {
            name+=Integer.toString(i);
            Thread_02.MyThread t = new Thread_02.MyThread(name);
        }
    }

    public static class MyThread extends Thread {
        MyThread(String name){
            super(name);
        }

        public void run(){
            for (int i = 0; i < 13; i++) {
                try {
                    print();
                    sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        synchronized public static void print() throws InterruptedException {
            sleep(200);
            System.out.printf("%s\n", Thread.currentThread().getName());

        }
    }
}
