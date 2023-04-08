package ex03;

import java.util.Arrays;

public class Program {
    static private String urlsFilePath = "C:\\Users\\79127\\Desktop\\java_github\\day03\\ex03\\files_urls.txt";
    public static void main(String[] args) {
//        java Program.java --threadsCount=3
        for (String i :
                args) {
            if (i.contains("--threadsCount=")) {
                String[] splittenArgs = i.split("=");
                Threads t = new Threads(Integer.parseInt(splittenArgs[1]));
                t.start(urlsFilePath);
//                System.out.println(splittenArgs[1]);
            }
        }
    }
}
