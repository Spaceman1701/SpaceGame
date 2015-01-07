package com.x2a.spacegame.scenes.planet.generation;

import com.x2a.spacegame.scenes.planet.Biome;
import com.x2a.spacegame.scenes.planet.biome.GrassBiome;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * Created by Ethan on 1/6/2015.
 */
public class BiomeFactory {

    private Random random;
    private long seed;

    private Class[] biomeClasses = {GrassBiome.class};

    public BiomeFactory(long seed) {
        this.seed = seed;
        random = new Random(seed);
    }

    public Biome getRandomBiome(float maxHeight, float minHeight, float averageHeight) {
        Class<? extends Biome> clazz = (Class<? extends Biome>) biomeClasses[random.nextInt(biomeClasses.length)];
        Class[] params = {Float.class, Float.class, Float.class};
        Float[] args = {maxHeight, minHeight, averageHeight};
        try {
            return clazz.getDeclaredConstructor(params).newInstance(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return null;
    }

    public static void main(String[] args) {
        BiomeFactory factory = new BiomeFactory(System.nanoTime());
        factory.getRandomBiome(0, 0, 0);
    }
}
