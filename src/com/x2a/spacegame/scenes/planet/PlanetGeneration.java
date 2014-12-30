package com.x2a.spacegame.scenes.planet;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by David on 12/29/2014.
 */
public class PlanetGeneration {

    public static final float DEVIATION = .05f;

    public PlanetGeneration() {

    }

    public BufferedImage generatePlanetImage(int width, int height) {
        byte[] dirtNormal = new byte[]{(byte) 0, (byte) 255, (byte) 0};
        byte[] waterNormal = new byte[]{(byte) 30, (byte) 144, (byte) 255};

        //byte[] img = new byte[width * height * 3];
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Random rnd = new Random();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                byte r = rangeColor((waterNormal[0] & 0xff) + (int) (((rnd.nextFloat() * 2.0f) - 1f) * DEVIATION * 255f));
                byte g = rangeColor((waterNormal[1] & 0xff) + (int) (((rnd.nextFloat() * 2.0f) - 1f) * DEVIATION * 255f));
                byte b = rangeColor((waterNormal[2] & 0xff) + (int) (((rnd.nextFloat() * 2.0f) - 1f) * DEVIATION * 255f));

                int v = RGBToInteger(r, g, b);

                img.setRGB(i, j, v);
            }
        }
        return img;
    }

    private static int RGBToInteger(byte r, byte g, byte b) {
        return (0xff << 24) | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
    }

    private static byte rangeColor(int value) {
        if (value < 0) {
            return 0;
        } else if (value > 255) {
            return (byte) 255;
        } else {
            return (byte) value;
        }
    }
}
