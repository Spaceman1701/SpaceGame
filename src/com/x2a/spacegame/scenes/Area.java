package com.x2a.spacegame.scenes;

import com.x2a.scene.Scene;
import com.x2a.spacegame.SpaceGame;

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
