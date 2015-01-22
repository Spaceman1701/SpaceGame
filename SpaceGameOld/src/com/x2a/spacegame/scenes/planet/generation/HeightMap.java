package com.x2a.spacegame.scenes.planet.generation;

import java.awt.*;
import java.util.Random;

/**
 * Created by Ethan on 1/6/2015.
 */
public class HeightMap {
    private float roughness;

    private int size;
    private int max;

    private float[] map;

    private long seed;

    private Random random;

    private float maxHeight;
    private float minHeight;

    /**
     *
     * @param seed
     * @param size must be power of two + 1. Examples: 5, 65, 129, 257, 1025
     * @param roughness value between 0 and 1. Higher values will result in greater height offsets. Lower values = flatter.
     */
    public HeightMap(long seed, int size, float roughness) {
        if (((size - 1) & (size - 2)) != 0) { //test for power of two
            throw new IllegalArgumentException("size is not power of two + 1");
        }
        this.roughness = roughness;
        this.seed = seed;
        this.size = size;
        max = size - 1;
        map = new float[size*size];

        random = new Random(seed);

        generate();

        maxHeight = findMax();
        minHeight = findMin();
    }

    private void generate() {
        initCorners();
        divide(max);
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
        int x;
        int y;
        int half = size/2;
        float fHalf = (float)size/2.0f;
        float scale = roughness * size;

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

    public float getValue(int x, int y) {
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

    public float[] getMap() {
        return map;
    }
}
