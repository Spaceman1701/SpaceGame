package com.x2a.spacegame.player;

import com.x2a.input.KeyEventData;
import com.x2a.input.MouseEventData;
import com.x2a.math.Vector2;
import com.x2a.scene.InputSprite;

/**
 * Created by Ethan on 12/29/2014.
 */
public class PlayerWarp extends InputSprite{

    private static final String IMAGE_LOCATION = "res/images/sprites/Spaceship 2.png";

    public PlayerWarp() {
        super(new Vector2(), 100, 100, 0, 0, IMAGE_LOCATION, "SPR_PLAYER_WARP");
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
