package com.x2a.spacegame.scenes.planet.biome.grass;

import com.x2a.spacegame.scenes.planet.biome.TerrainType;
import com.x2a.spacegame.scenes.planet.terrain.TerrainData;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Ethan on 1/6/2015.
 */
public enum GrassTerrainType implements TerrainType {

    GRASS(new TerrainData(new Color(119, 190, 119), GRASS_IMAGE_LOCATION)),
    SAND(new TerrainData(new Color(253, 253, 150), SAND_IMAGE_LOCATION)),
    OCEAN(new TerrainData(new Color(119, 158, 203), OCEAN_TEXTURE_LOCATION)),
    ROCK(new TerrainData(new Color(130, 105, 83), ROCK_TEXTURE_LOCATION));

    private TerrainData data;

    GrassTerrainType(TerrainData data) {
        this.data = data;
    }


    @Override
    public TerrainData getData() {
        return data.duplicate();
    }
}
