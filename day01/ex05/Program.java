package ex05;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String mode = "";
        if(args.length > 0) {
            mode = args[0];
        }
        Menu m = new Menu(mode);
        m.start();
    }
}
