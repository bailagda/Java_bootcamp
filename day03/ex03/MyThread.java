package ex03;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MyThread extends Thread{
    private BufferedReader reader;
    MyThread(String name, BufferedReader reader) {
        super(name);
        this.reader = reader;
    }
    @Override
    public void run(){
        try {
            for(;;) {
                String s = reader.readLine();
                if (s != null){
                    String[] fileUrl = s.split(" ");
                    System.out.printf("%s start download file number %s\n", this.getName(), fileUrl[0]);
                    BufferedInputStream in = new BufferedInputStream(new URL(fileUrl[1]).openStream());
                    Files.copy(in, Paths.get("/Users/bailagda/Desktop/java_bootcamp/day03/ex03/test/"),
                            StandardCopyOption.REPLACE_EXISTING);
                    System.out.printf("%s finish download file number %s\n", this.getName(), fileUrl[0]);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
