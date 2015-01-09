package com.x2a.spacegame.scenes.planet.biome.rock;

import com.x2a.spacegame.scenes.planet.biome.TerrainType;
import com.x2a.spacegame.scenes.planet.terrain.TerrainData;

import java.awt.*;

/**
 * Created by Ethan on 1/8/2015.
 */
public enum RockTerrainType implements TerrainType{

    LAVA(new TerrainData(new Color(255, 105, 97), LAVA_IMAGE_LOCATION)),
    LAVA_ROCK(new TerrainData(new Color(113, 113, 113), LAVA_ROCK_IMAGE_LOCATION)),
    STONE(new TerrainData(new Color(207, 207, 196), STONE_IMAGE_LOCATION)),
    MOUNTAIN_ROCK(new TerrainData(new Color(194, 102, 102), MOUNTAIN_STONE_IMAGE_LOCATION));




    private TerrainData data;

    RockTerrainType(TerrainData data) {
        this.data = data;
    }

    @Override
    public TerrainData getData() {
        return data.duplicate();
    }
}
