package ex02;

import java.io.IOException;

public class Program {
    private String flagPath = "--current-folder=";
    private static ComandLine cmdLine= new ComandLine();
    public static void main(String[] args) throws IOException {
        if(args.length > 0) {
            String filePath = getPath(args[0]);
            System.out.println(filePath);
            cmdLine.startExec(filePath);
        }
    }
    private static String getPath(String arg) {
        return (arg.split("="))[1];
    }
}
