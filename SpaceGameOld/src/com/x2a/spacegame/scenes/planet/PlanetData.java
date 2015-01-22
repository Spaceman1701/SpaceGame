package com.x2a.spacegame.scenes.planet;

import com.x2a.Application;
import com.x2a.render.ImageUtil;
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

    private boolean loaded;

    public PlanetData(long seed) {
        this.seed = seed;


    }

    public static PlanetData generatePlanetData() {
        return new PlanetData(Application.APP_RANDOM.nextLong());
    }

    public void loadData() {
        heightMap = new HeightMap(seed, 257, 0.8f);
        BiomeFactory biomeFactory = new BiomeFactory(seed);
        biome = biomeFactory.getRandomBiome(heightMap.getMaxHeight(), heightMap.getMinHeight(), 0.0f);
        loaded = true;
    }

    public void loadData(int size) {
        heightMap = new HeightMap(seed, size, 0.8f);
        BiomeFactory biomeFactory = new BiomeFactory(seed);
        biome = biomeFactory.getRandomBiome(heightMap.getMaxHeight(), heightMap.getMinHeight(), 0.0f);
        loaded = true;
    }

    public void unloadData() {
        heightMap = null;
        biome = null;
        loaded = false;
    }

    public boolean isLoaded() {
        return loaded;
    }


    public BufferedImage getColorImage() {
        checkLoaded();
        BufferedImage image = new BufferedImage(heightMap.getSize(), heightMap.getSize(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < heightMap.getSize(); x++) {
            for (int y = 0; y <heightMap.getSize(); y++) {
                Color color= biome.getTerrainData(heightMap.getValue(x, y)).getColor();
                //System.out.println(color);
                image.setRGB(x, y, color.getRGB());
            }
        }
        ImageUtil.circleMaskImage(image, heightMap.getSize()/2, 0);
        return image;
    }

    private void checkLoaded() throws IllegalStateException{
        if (!loaded) {
            throw new IllegalStateException("HeightData not loaded!");
        }
    }

}
