package com.x2a.spacegame.scenes.planet;

import com.x2a.spacegame.scenes.planet.biome.TerrainType;
import com.x2a.spacegame.scenes.planet.terrain.TerrainData;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Biome {

    private float maxHeight;
    private float minHeight;
    private float averageHeight;

    public Biome(Float maxHeight, Float minHeight, Float averageHeight) {
        this.maxHeight = maxHeight.floatValue();
        this.minHeight = minHeight.floatValue();
        this.averageHeight = averageHeight.floatValue();
    }

    public BufferedImage getImage(float height) {
        return getTerrainTypeFromHeight(height).getImage();
    }

    public Color getColor(float height) {
        return getTerrainTypeFromHeight(height).getColor();
    }

    public TerrainData getTerrainData(float height) {
        return getTerrainTypeFromHeight(height).getData();
    }

    protected abstract TerrainType getTerrainTypeFromHeight(float height);

    public float getMaxHeight() {
        return maxHeight;
    }

    public float getMinHeight() {
        return minHeight;
    }

    public float getAverageHeight() {
        return averageHeight;
    }
}
