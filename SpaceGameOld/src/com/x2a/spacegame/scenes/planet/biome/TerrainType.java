package com.x2a.spacegame.scenes.planet.biome;

import com.x2a.spacegame.scenes.planet.terrain.TerrainData;

/**
 * Created by Ethan on 1/6/2015.
 */
public interface TerrainType {


    /**
     * GRASS BIOME IMAGE LOCATIONS
     */
    static final String GRASS_IMAGE_LOCATION = "";
    static final String SAND_IMAGE_LOCATION = "";
    static final String OCEAN_TEXTURE_LOCATION = "";
    static final String ROCK_TEXTURE_LOCATION = "";

    /**
     * ROCK BIOME IMAGE LOCATIONS
     */
    static final String LAVA_IMAGE_LOCATION = "";
    static final String LAVA_ROCK_IMAGE_LOCATION = "";
    static final String STONE_IMAGE_LOCATION = "";
    static final String MOUNTAIN_STONE_IMAGE_LOCATION = "";

    public TerrainData getData();
}
