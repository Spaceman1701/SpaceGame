package com.x2a.spacegame.player;

import com.x2a.input.KeyEventData;
import com.x2a.input.MouseEventData;
import com.x2a.math.Vector2;
import com.x2a.scene.InputSprite;

/**
 * Created by Ethan on 12/29/2014.
 */
public class PlayerGround extends InputSprite{


    public PlayerGround(Vector2 position, float height, float width, float rotation, float depth, String imageLocation, String name) {
        super(position, height, width, rotation, depth, imageLocation, name);
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
