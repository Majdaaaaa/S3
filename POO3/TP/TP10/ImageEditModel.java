import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;

public class ImageEditModel {
    private BufferedImage image;

    public ImageEditModel(String chemin) {
        try {
            this.image = ImageIO.read(new File(chemin));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void fillzone(Rectangle z, int[][] pixels) {
        for (int i = 0; i < z.height; i++) {
            for (int j = 0; j < z.width; j++) {
                image.setRGB(z.height, z.width, pixels[i][j]);
            }
        }
    }

    public void clearzone(Rectangle z) {
        Color color = Color.white;
        int srgb = color.getRGB();
        int[][] pixels=new int[z.height][z.width];
        for (int i = 0; i < z.height; i++) {
            for (int j = 0; j < z.width; j++) {
                pixels[i][j]=srgb;
            }
        }
        fillzone(z, pixels);
    }

    public class Coupe{
        Rectangle z;
        int[][] pixels;
        public Coupe(int x,int y,int l,int h,BufferedImage img){
            
        }
    }

}