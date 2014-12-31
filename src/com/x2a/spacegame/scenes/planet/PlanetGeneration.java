package com.x2a.spacegame.scenes.planet;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by David on 12/29/2014.
 */
public class PlanetGeneration {

    public static final float DEVIATION = .05f;

    public PlanetGeneration() {

    }

    public BufferedImage generatePlanetImage(int width, int height) {
        byte[] black = new byte[]{(byte) 0, (byte) 0, (byte) 0};
        byte[] white = new byte[]{(byte) 255, (byte) 255, (byte) 255};
        byte[] dirtNormal = new byte[]{(byte) 139, (byte) 69, (byte) 19};
        byte[] waterNormal = new byte[]{(byte) 30, (byte) 144, (byte) 255};

        //byte[] img = new byte[width * height * 3];
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        BitMap map = new BitMap(width, height);
        Random rnd = new Random();
        map.randomize(rnd);
        map.unify(0, 1, 3);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //img.setRGB(i, j, bytesToARGB(randomizeRGB(waterNormal, rnd, .02f)));
                if (map.get(i, j))
                    img.setRGB(i, j, bytesToARGB(white));
                else
                    img.setRGB(i, j, bytesToARGB(black));
            }
        }

        return img;
    }

    private static byte[] randomizeRGB(byte[] rgb, Random rnd, float stdDev) {
        return new byte[] {
                rangeColor((rgb[0] & 0xff) + (int) (rnd.nextGaussian() * stdDev * 256f)),
                rangeColor((rgb[1] & 0xff) + (int) (rnd.nextGaussian() * stdDev * 256f)),
                rangeColor((rgb[2] & 0xff) + (int) (rnd.nextGaussian() * stdDev * 256f))};
    }

    private static int bytesToARGB(byte r, byte g, byte b) {
        return (0xff << 24) | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
    }

    private static int bytesToARGB(byte[] rgb) {
        return (0xff << 24) | ((rgb[0] & 0xff) << 16) | ((rgb[1] & 0xff) << 8) | (rgb[2] & 0xff);
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

    private class BitMap {

        private boolean[] map;
        private int width;
        private int height;

        public BitMap(int width, int height) {
            map = new boolean[width * height];
            this.width = width;
            this.height = height;
        }

        public boolean get(int x, int y) {
            return map[width * y + x];
        }

        public void set(int x, int y, boolean value) {
            map[width * y + x] = value;
        }

        public boolean cellExists(int x, int y) {
            return x >= 0 && y >= 0 && x < width && y < height;
        }

        public void randomize(Random rnd) {
            for (int i = 0; i < map.length; i++) {
                map[i] = rnd.nextBoolean();
            }
        }

        public void unify(int min3, int min5, int min8) {
            int[] xSwap = new int[]{0, -1, 1}; // Try these random values
            int[] ySwap = new int[]{1, -1, 0};

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    float neighbors = 0;
                    float positives = 0;

                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            if (cellExists(k, l) && i != k && j != l) {
                                neighbors++;
                                if (get(k, l))
                                    positives++;
                            }
                        }
                    }

                    //if (neighbors - positives > positives + 1) { // More negatives than positives
                    if (neighbors == 3 && positives <= min3 ||
                            neighbors == 5 && positives <= min5 ||
                            neighbors == 8 && positives <= min8) { // Doesn't meet minimum number of nieghbors
                        for (int k = 0; k < 3; k++) {
                           for (int l = 0; l < 3; l++) {
                               if (cellExists(i + xSwap[k], i + ySwap[l]) && // Cell exists, empty, and not same
                                       get(i + xSwap[k], i + ySwap[l]) && xSwap[k] != 0 && ySwap[l] != 0) {
                                   set(i + xSwap[k], i + ySwap[l], true);
                                   set(i, j, false);
                               }
                           }
                        }
                    }
                }
            }
        }
    }
}
