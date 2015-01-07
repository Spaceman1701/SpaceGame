package com.x2a.spacegame.scenes.planet.biome;

import com.x2a.spacegame.scenes.planet.terrain.TerrainData;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Ethan on 1/6/2015.
 */
public interface TerrainType {

    static final String GRASS_IMAGE_LOCATION = "";
    static final String SAND_IMAGE_LOCATION = "";
    static final String OCEAN_TEXTURE_LOCATION = "";
    static final String ROCK_TEXTURE_LOCATION = "";

    public BufferedImage getImage();

    public Color getColor();

    public TerrainData getData();
}
