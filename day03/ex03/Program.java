package ex03;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class Program {
    static private File urlsfile = new File(
            "/Users/bailagda/Desktop/java_bootcamp/day03/ex03/files_urls.txt");
    public static void main(String[] args) throws IOException {
        int threadsCount = 0;
        for (String i : args) {
            if (i.contains("--threadsCount=")) {
                String[] splittenArgs = i.split("=");
                threadsCount = Integer.parseInt(splittenArgs[1]);
            }
        }
        MyThread[] threads = new MyThread[threadsCount];
        FileReader fr = new FileReader(urlsfile);
        BufferedReader reader = new BufferedReader(fr);

        for(int i = 0; i< threads.length; ++i){
            threads[i] = new MyThread("Thread "+ i, reader);
        }
        for (MyThread t: threads) {
            t.start();
        }
    }
}
