package com.x2a.spacegame.scenes.planet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Ethan on 1/5/2015.
 */
public class PlanetGen {

    private static int DETAIL = 7;
    private static float ROUGHNESS = 0.5f;

    private int size;
    private int max;
    private float[] map;

    private Random random;

    private float maxHeight;
    private float minHeight;

    private int iter;

    public PlanetGen() {
        size = (int)Math.pow(2, DETAIL) + 1;
        max = size - 1;
        map = new float[size*size];

        random = new Random();

        initCorners();
        iter = 0;
        divide(max);

        maxHeight = findMax();
        minHeight = findMin();
    }

    private float findMax() {
        float max = Float.MIN_VALUE;
        for (float f : map) {
            if (f > max) {
                max = f;
            }
        }
        return max;
    }

    private float findMin() {
        float min = Float.MAX_VALUE;
        for (float f : map) {
            if (f < min) {
                min = f;
            }
        }
        return min;
    }

    private void initCorners() {
        setValue(0, 0, max/2);
        setValue(max, max, max/2);
        setValue(0, max, max/2);
        setValue(max, 0, max/2);
    }

    private void divide(int size) {
        iter++;
        System.out.println(iter);
        int x;
        int y;
        int half = size/2;
        float fHalf = (float)size/2.0f;
        float scale = ROUGHNESS * size;

        if (fHalf < 1) {
            return;
        }

        for (y = half; y < max; y += size) {
            for (x = half; x < max; x += size) {
                //System.out.println("Square: " + x + ", " + y);
                square(x, y, half, random.nextFloat() * scale * 2 - scale);
            }
        }

        for (y = 0; y <= max; y += half) {
            for (x = (y + half) % size; x <= max; x += size) {
                diamond(x, y, half, random.nextFloat() * scale * 2 - scale);
            }
        }

        divide(size/2);
    }

    public BufferedImage getHeightMap() {
        Color averageColor = new Color(128, 128, 128);
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int heightColor = heightToColor(getValue(x, y));
                System.out.println(heightColor);
                Color color = new Color(heightColor, heightColor, heightColor);
                image.setRGB(x, y, color.getRGB());
            }
        }

        return image;
    }

    private int heightToColor(float height) {
        float heightRange = (maxHeight - minHeight);
        float colorRange = 255;

        float value = (((height - minHeight) * colorRange) / heightRange);

        return (int)value;
    }

    private void square(int x, int y, int size, float offset) {
        float average = average(getValue(x - size, y - size), getValue(x - size, y + size), getValue(x + size, y + size), getValue(x + size, y - size));
        setValue(x, y, average + offset);
    }

    private void diamond(int x, int y, int size, float offset) {
        //System.out.println("diamond: " + x +", " + y +", size = " + size);
        float average = average(getValue(x, y - size), getValue(x + size, y), getValue(x, y + size), getValue(x - size, y));
        setValue(x, y, average + offset);
    }

    private void setValue(int x, int y, float value) {
        map[x + size*y] = value;
    }

    private float getValue(int x, int y) {
        if (x < 0) {
            x = 0;
        } else if (x >= size) {
            x = size - 1;
        }
        if (y < 0) {
            y = 0;
        } else if (y >= size) {
            y = size -1;
        }
        try {
            float value = map[x + size * y];
        } catch (Exception e) {
            System.err.println(x + ", " + y);
            e.printStackTrace();
            System.exit(-1);
        }
        return map[x + size * y];
    }

    private float average(float a, float b, float c, float d) {
        return (a + b + c +d)/4.0f;
    }

    public int getSize() {
        return size;
    }

    public float getMinHeight() {
        return minHeight;
    }

    public float getMaxHeight() {
        return maxHeight;
    }
}