package ImagesToChar.src.java.edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToChar {
    private char white;
    private char black;
    private String pathToImage;

    public ImageToChar(String w, String b, String pathToImage){
        white = w.toCharArray()[0];
        black = b.toCharArray()[0];
        this.pathToImage = pathToImage;
    }

    public void execute() throws IOException {
        BufferedImage img = ImageIO.read(new File(pathToImage));
        for(int x = 0; x < img.getHeight(); ++x) {
            for(int y = 0; y < img.getWidth(); ++y) {
                int colorCode = img.getRGB(y, x);
                printChar(colorCode);
            }
            System.out.println('\n');
        }
    }

    private void printChar(int colorCode) {
        if(colorCode == -16777216) {
            System.out.print(black);
        } else if (colorCode == -1) {
            System.out.print(white);
        }
    }
}
