package com.x2a.spacegame;

import com.x2a.game.Game;
import com.x2a.math.Vector2;
import com.x2a.scene.Sprite;

/**
 * Created by Ethan on 12/28/2014.
 */
public class SpaceGame extends Game {

    Sprite test;

    public SpaceGame() {
        test = new TestSprite();
    }

    @Override
    public void update(float timeElapsed) {
        test.draw();
    }
}
