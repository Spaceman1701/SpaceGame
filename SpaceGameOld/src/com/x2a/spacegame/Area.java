package com.x2a.spacegame;

import com.x2a.scene.Scene;

/**
 * Created by Ethan on 12/29/2014.
 */
public abstract class Area extends Scene{

    private SpaceGame game;

    public Area(SpaceGame game) {
        this.game = game;
    }

    public SpaceGame getGame() {
        return game;
    }
}
