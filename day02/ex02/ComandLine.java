package ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class ComandLine {
    private Scanner scan = new Scanner(System.in);
    private String mainDir;
    private File dir;
    private String lastCmd;
    protected void startExec(String filePath) throws IOException {
        mainDir = filePath;
        dir = new File(mainDir);
        for(;;) {
            lastCmd = scan.nextLine();
            if(lastCmd.equals("ls")) {
                showDirectoryCmd();
            } else if(lastCmd.contains("mv")) {
                moveCmd();
            } else if(lastCmd.contains("cd")) {
                toDirectoryCmd();
            } else if(lastCmd.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("Command Not Found");
            }
        }
    }
    private void moveCmd() {

    }
    private void toDirectoryCmd() {
        String[] cdWhere = lastCmd.split(" ");
        if(cdWhere.length == 2) {
            mainDir = mainDir + "\\" + cdWhere[1];
            System.out.println(mainDir);
            dir = new File(mainDir);
        }
    }

    private void showDirectoryCmd() throws IOException {
        for(File i: Objects.requireNonNull(dir.listFiles())) {
            System.out.printf("%s %d KB\n", i.getName(), getFolderSize(i.toPath()));
        }
    }
    public long getFolderSize(Path folder) throws IOException {
        return Files.walk(folder)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
    }
}
