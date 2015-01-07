package com.x2a.spacegame.scenes.planet.biome;

import com.x2a.spacegame.scenes.planet.terrain.TerrainData;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Ethan on 1/6/2015.
 */
public enum GrassTerrainType implements TerrainType {

    GRASS(new Color(119, 190, 119), GRASS_IMAGE_LOCATION),
    SAND(new Color(253, 253, 150), SAND_IMAGE_LOCATION),
    OCEAN(new Color(119, 158, 203), OCEAN_TEXTURE_LOCATION),
    ROCK(new Color(130, 105, 83), ROCK_TEXTURE_LOCATION);

    private String textureLoc;
    private Color color;

    GrassTerrainType(Color color, String textureLoc) {
        this.textureLoc = textureLoc;
        this.color = color;
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public TerrainData getData() {
        return null;
    }
}
