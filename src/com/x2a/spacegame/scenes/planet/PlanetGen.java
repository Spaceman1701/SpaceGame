package com.x2a.spacegame.scenes.planet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Ethan on 1/5/2015.
 */
public class PlanetGen {

    private static int DETAIL = 8;
    private static float ROUGHNESS = 0.8f;

    private int size;
    private int max;

    private float[] map;
    private Color[] colorMap;
    private long seed;

    private Random random;

    private float maxHeight;
    private float minHeight;

    private int iter;

    public PlanetGen(long seed) {
        this.seed = seed;
        size = (int)Math.pow(2, DETAIL) + 1;
        max = size - 1;
        map = new float[size*size];
        colorMap = new Color[size*size];

        random = new Random(seed);

        initCorners();
        iter = 0;
        divide(max);

        maxHeight = findMax();
        minHeight = findMin();

        fillColorMap();
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
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int heightColor = heightToColor(getValue(x, y));
                Color color = new Color(heightColor, heightColor, heightColor);
                image.setRGB(x, y, color.getRGB());
            }
        }

        return image;
    }

    private void fillColorMap() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int heightColor = heightToColor(getValue(x, y));
                Color color = getColorFromHeight(heightColor);
                colorMap[x + size*y] = color;
            }
        }
    }

    public BufferedImage getColorMap() {
        Color averageColor = new Color(128, 128, 128);
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                image.setRGB(x, y, colorMap[x + size * y].getRGB());
            }
        }

        return image;
    }

    private Color getColorFromHeight(int normalizedHeight) {
        Color ground = new Color(130, 105, 83);
        Color grass = new Color(119, 190, 119);
        Color sand = new Color(253, 253, 150);
        Color pastelWater = new Color(119, 158, 203);

        if (normalizedHeight >= 0 && normalizedHeight < 128) {
            return pastelWater;
        } else if (normalizedHeight >= 128 && normalizedHeight < 160) {
            return sand;
        } else if (normalizedHeight >= 160 && normalizedHeight < 210) {
            return grass;
        } else if (normalizedHeight >= 210 && normalizedHeight < 256) {
            return ground;
        }
        return ground;
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
