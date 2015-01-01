package com.x2a.spacegame.warp;

import com.x2a.Application;
import com.x2a.input.KeyEventData;
import com.x2a.input.MouseEventData;
import com.x2a.math.Vector2;
import com.x2a.scene.InputSprite;

/**
 * Created by Ethan on 12/29/2014.
 */
public class MapEarth extends InputSprite {

    private static final String IMAGE_LOCATION = "res/images/sprites/MapEarth.png";

    public MapEarth() {
        super(new Vector2(-4500, -4500), 10, 10, 0, 10, IMAGE_LOCATION, "MAP_EARTH");
    }

    @Override
    public void onKeyEvent(KeyEventData data) {

    }

    @Override
    public void onMouseEvent(MouseEventData data) {

    }

    @Override
    public void update(float timeElapsed) {

    }
}
