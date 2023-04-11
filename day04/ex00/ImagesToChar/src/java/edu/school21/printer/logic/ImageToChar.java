package ImagesToChar.src.java.edu.school21.printer.logic;

import javax.imageio.ImageIO;
import javax.xml.bind.SchemaOutputResolver;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
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
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "bmp", baos);
        byte[] byteArr = baos.toByteArray();

    }
}
