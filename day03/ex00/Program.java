package ex00;

public class Program {
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
        try {
            t.join();
            s.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < COUNT; i++) {
            System.out.println("Human");
        }
    }
    public static class MyThread extends Thread {
        MyThread(String name){
            super(name);
        }

        public void run(){
            for (int i = 0; i < COUNT; i++) {
                System.out.printf("%s\n", Thread.currentThread().getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
