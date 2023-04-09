package ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
                String fileUrl = reader.readLine();
                System.out.printf("%s -> %s\n", this.getName(), fileUrl);
                InputStream in = new URL(fileUrl).openStream();
                Files.copy(in, Paths.get("C:\\Users\\79127\\Desktop\\java_github\\day03"),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try (InputStream in = url.openStream()) {
//            Files.copy(in, Paths.get(fileName));
//        }
    }
}
