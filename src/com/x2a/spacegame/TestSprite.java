package com.x2a.spacegame;

import com.x2a.math.Vector2;
import com.x2a.scene.Sprite;

/**
 * Created by Ethan on 12/28/2014.
 */
public class TestSprite extends Sprite {


    public TestSprite() {
        super(new Vector2(), 100, 100, 0, "res/images/sprites/Test Sprite Image.png", "test");
    }

    @Override
    public void act(float timeElapsed) {

    }
}
