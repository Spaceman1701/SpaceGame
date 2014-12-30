package com.x2a.spacegame.warp;

import com.x2a.input.KeyEventData;
import com.x2a.input.MouseEventData;
import com.x2a.math.Vector2;
import com.x2a.scene.InputSprite;

/**
 * Created by Ethan on 12/29/2014.
 */
public class MapPlanet extends InputSprite{

    private static final String IMAGE_LOCATION = "res/images/sprites/MapPlanet.png";

    private int id;

    public MapPlanet(Vector2 position, int id) {
        super(position, 20, 20, 0, 10, IMAGE_LOCATION, "planet_" + id);

        this.id = id;
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
