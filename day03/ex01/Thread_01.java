package ex01;

public class Thread_01 {
    static int COUNT = 10;
    public static void main(String[] args) {
        for(String i: args) {
            if(i.contains("--count=")) {
                COUNT = Integer.parseInt((i.split("="))[1]);
            }
        }
        MyThread t = new MyThread("Hun");
        MyThread s = new MyThread("Egg");
        t.start();
        s.start();
    }
    public static class MyThread extends Thread {
        public MyThread(String name){
            super(name);
        }

        public void run(){
            for (int i = 0; i < COUNT; i++) {
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
