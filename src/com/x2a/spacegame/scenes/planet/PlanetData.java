package com.x2a.spacegame.scenes.planet;

import com.x2a.spacegame.scenes.planet.generation.BiomeFactory;
import com.x2a.spacegame.scenes.planet.generation.HeightMap;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Ethan on 1/6/2015.
 */
public class PlanetData {

    private long seed;

    private HeightMap heightMap;
    private Biome biome;

    public PlanetData(long seed) {
        this.seed = seed;

        heightMap = new HeightMap(seed, 257, 0.8f);

        BiomeFactory biomeFactory = new BiomeFactory(seed);

        biome = biomeFactory.getRandomBiome(heightMap.getMaxHeight(), heightMap.getMinHeight(), 0.0f);
    }

    public static PlanetData generatePlanetData() {
        return new PlanetData(System.nanoTime());
    }


    public BufferedImage getColorImage() {
        BufferedImage image = new BufferedImage(heightMap.getSize(), heightMap.getSize(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < heightMap.getSize(); x++) {
            for (int y = 0; y <heightMap.getSize(); y++) {
                Color color= biome.getTerrainTypeFromHeight(heightMap.getValue(x, y)).getColor();
                //System.out.println(color);
                image.setRGB(x, y, color.getRGB());
            }
        }

        return image;
    }

}
