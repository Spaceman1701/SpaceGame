package com.x2a.render;

import com.x2a.math.GameMath;
import com.x2a.math.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Ethan on 1/8/2015.
 */
public class ImageUtil {

    private ImageUtil() {}

    /**
     *
     * @param image
     * @param mask
     * @return image with modified alpha channel
     */
    public static BufferedImage maskImage(BufferedImage image, BufferedImage mask) {
        if (image.getHeight() - mask.getHeight() != 0 || image.getWidth() - mask.getWidth() != 0) {
            throw new IllegalArgumentException("Mask and image are not the same size!");
        }

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color color = new Color(image.getRGB(x, y));
                Color maskColor = new Color(mask.getRGB(x, y));
                image.setRGB(x, y, new Color(color.getRed(), color.getGreen(), color.getBlue(), maskColor.getRed()).getRGB());
            }
        }

        return image;
    }

    /**
     *
     * @param image
     * @param radius
     * @param alphaOutside alpha values of pixels outside the circle centered at the center of the image with radius {@code radius}
     * @return image with modified alpha channel
     */
    public static BufferedImage circleMaskImage(BufferedImage image, float radius, int alphaOutside) {
        float radius2 = radius*radius;

        Vector2 center = new Vector2(image.getWidth()/2.0f, image.getHeight()/2.0f);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y <image.getHeight(); y++) {
                if (GameMath.getDistance2(center, new Vector2(x, y)) > radius2) {
                    Color color = new Color(image.getRGB(x, y));
                    image.setRGB(x, y, new Color(color.getRed(), color.getGreen(), color.getBlue(), alphaOutside).getRGB());
                }
            }
        }

        return image;
    }
}
