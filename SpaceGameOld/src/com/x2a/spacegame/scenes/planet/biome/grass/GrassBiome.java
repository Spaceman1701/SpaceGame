package com.x2a.spacegame.scenes.planet.biome.grass;

import com.x2a.math.GameMath;
import com.x2a.spacegame.scenes.planet.Biome;

public class GrassBiome extends Biome {


    public GrassBiome(Float maxHeight, Float minHeight, Float averageHeight) {
        super(maxHeight, minHeight, averageHeight);

        System.out.println(getMaxHeight());
    }

    protected GrassTerrainType getTerrainTypeFromHeight(float height) {
        float normalizedHeight = GameMath.convertToUnitRange(height, getMinHeight(), getMaxHeight());
        if (GameMath.betweenTwoValues(normalizedHeight, 0.0f, 0.5f)) {
            return GrassTerrainType.OCEAN;
        } else if (GameMath.betweenTwoValues(normalizedHeight, 0.5f, 0.7f)) {
            return GrassTerrainType.SAND;
        } else if (GameMath.betweenTwoValues(normalizedHeight, 0.7f, 0.9f)) {
            return GrassTerrainType.GRASS;
        }
        return GrassTerrainType.ROCK;
    }
}
