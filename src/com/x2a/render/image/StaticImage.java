package com.x2a.render.image;

import com.x2a.render.DrawImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ethan on 12/31/2014.
 */
public class StaticImage implements DrawImage {
    private BufferedImage image;


    public StaticImage(BufferedImage image) {
        this.image = image;
    }

    /**
     *
     * @param pixels ARGB format
     * @param width
     * @param height
     */
    public StaticImage(int[] pixels, int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0, 0, width, height, pixels);
    }

    public static StaticImage loadImage(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        return new StaticImage(image);
    }


    @Override
    public void draw(Graphics2D g2, float width, float height) {
        g2.drawImage(image, 0, 0, (int)width, (int)height, null);
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    public Raster getData() {
        return image.getData();
    }
}
