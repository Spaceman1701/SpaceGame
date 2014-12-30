package com.x2a.spacegame;

import com.x2a.math.Vector2;
import com.x2a.spacegame.scenes.planet.PlanetGeneration;

/**
 * Created by Ethan on 12/29/2014.
 */
public class PlanetArea extends Area {

    public PlanetArea(SpaceGame game) {
        super(game);
        getChildren().add(new TestSprite(new Vector2(0, 0), "stuff", 1.0f, new PlanetGeneration().generatePlanetImage(100, 100)));
    }
}
