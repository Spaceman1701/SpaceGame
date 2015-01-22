package com.x2a.spacegame.scenes.planet.biome.rock;

import com.x2a.math.GameMath;
import com.x2a.spacegame.scenes.planet.Biome;
import com.x2a.spacegame.scenes.planet.biome.TerrainType;

/**
 * Created by Ethan on 1/8/2015.
 */
public class RockBiome extends Biome{

    public RockBiome(Float maxHeight, Float minHeight, Float averageHeight) {
        super(maxHeight, minHeight, averageHeight);
    }

    @Override
    protected TerrainType getTerrainTypeFromHeight(float height) {
        float normalizedHeight = GameMath.convertToUnitRange(height, getMinHeight(), getMaxHeight());
        if (GameMath.betweenTwoValues(normalizedHeight, 0.0f, 0.5f)) {
            return RockTerrainType.LAVA;
        } else if (GameMath.betweenTwoValues(normalizedHeight, 0.5f, 0.7f)) {
            return RockTerrainType.LAVA_ROCK;
        } else if (GameMath.betweenTwoValues(normalizedHeight, 0.7f, 0.9f)) {
            return RockTerrainType.STONE;
        }
        return RockTerrainType.MOUNTAIN_ROCK;
    }
}
