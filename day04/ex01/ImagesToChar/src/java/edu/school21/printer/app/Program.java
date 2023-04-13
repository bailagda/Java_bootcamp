package ex01.ImagesToChar.src.java.edu.school21.printer.app;

// java ImageToChar -w=. -b=O pathToFile(absolete)

import ex01.ImagesToChar.src.java.edu.school21.printer.logic.ImageToChar;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        String pathToFile = "";
        String white = "";
        String black = "";
        if(args.length == 3) {
            for(String arg : args) {
                if(arg.contains("-w")){
                    white = arg.split("=")[1];
                } else if (arg.contains("-b")) {
                    black = arg.split("=")[1];
                } else {
                    pathToFile = arg;
                }
            }
        } else {
            System.out.println("Wrong args!");
            System.exit(1);
        }
        ImageToChar im = new ImageToChar(white, black, pathToFile);
        im.execute();
    }
}
