package com.x2a.spacegame;

import com.x2a.Application;
import com.x2a.math.Vector2;
import com.x2a.scene.Sprite;

/**
 * Created by Ethan on 12/29/2014.
 */
public class Background extends Sprite{
    public Background(String imageLocation, String name) {
        super(new Vector2(), Application.X_RES, Application.Y_RES, 0, 10000, imageLocation, name);
    }

    @Override
    public void update(float timeElapsed) {

    }
}
