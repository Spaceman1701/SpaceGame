package com.x2a.spacegame.scenes.planet.biome;

import com.x2a.spacegame.scenes.planet.Biome;

public class GrassBiome extends Biome {


    public GrassBiome(Float maxHeight, Float minHeight, Float averageHeight) {
        super(maxHeight, minHeight, averageHeight);

        System.out.println(averageHeight);
    }

    protected GrassTerrainType getTerrainTypeFromHeight(float height) {
        if (height < 100) {
            return GrassTerrainType.GRASS;
        }
        return null;
    }
}
