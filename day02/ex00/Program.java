package ex00;

import java.io.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {
        FileReader signalFile = null;
        FileInputStream fileStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            signalFile = new FileReader("ex00/signal.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Cannot read file signal.txt");
            System.exit(-1);
        }

        BufferedReader bufferedReader = new BufferedReader(signalFile);
        String name;
        while ((name = bufferedReader.readLine()) != null) {
            FileType.fillMap(name);
        }
        System.out.println(FileType.signal);

        try {
            fileOutputStream = new FileOutputStream("ex00/result.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Cannot create file result.txt");
            System.exit(-1);
        }

        Scanner in = new Scanner(System.in);
        String pathToFile = "";
        pathToFile = in.nextLine();
        while (!pathToFile.equals("42")) {
            try {
                FileInputStream fis = new FileInputStream(pathToFile);
                int sym;
                String firstBytes = "";
                for(int i = 1; i != 8; ++i) {
                    sym = fis.read();
                    firstBytes = firstBytes + Integer.toHexString(sym) ;
                }
                int flagWasWrited = 0;
                for(String val : FileType.signal.keySet()) {
                    if (firstBytes.contains(val)) { // to res!
                        flagWasWrited = 1;
                        System.out.println("PROCESSED");
                        fileOutputStream.write(FileType.signal.get(val).getBytes());
                        fileOutputStream.write('\n');
                    }
                }
                if(flagWasWrited != 1) { System.out.println("UNDEFINED");}

            } catch (FileNotFoundException e) {
                System.err.print("File does not exist");
                System.exit(-1);
            }
            pathToFile = in.nextLine();
        }
    }
}
