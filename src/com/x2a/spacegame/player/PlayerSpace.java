package com.x2a.spacegame.player;

import com.x2a.input.KeyEventData;
import com.x2a.input.KeyEventType;
import com.x2a.input.MouseEventData;
import com.x2a.math.GameMath;
import com.x2a.math.Vector2;
import com.x2a.scene.InputSprite;

/**
 * Created by Ethan on 12/29/2014.
 */
public class PlayerSpace extends InputSprite {

    private static final String IMAGE_LOCATION = "res/images/sprites/Spaceship 2.png";

    private float maxSpeed = 3;

    private float speed = 0;

    public PlayerSpace() {
        super(new Vector2(), 150, 150, 0, 1f, IMAGE_LOCATION, "SPR_PLAYER_SPACE");
    }

    @Override
    public void onKeyEvent(KeyEventData data) {
        if (data.getEventType() == KeyEventType.KEY_TYPED) {
            switch (Character.toLowerCase(data.getKeyChar())) {
                case 'w':
                    speed += 0.11f;
                    break;
                case 's':
                    speed -= 0.11f;
                    break;
                case 'a':
                    rotate(-0.05f);
                    break;
                case 'd':
                    rotate(0.05f);
                    break;
            }
        }
    }

    @Override
    public void onMouseEvent(MouseEventData data) {

    }

    @Override
    public void update(float timeElapsed) {
        if (Math.abs(speed) > maxSpeed) {
            speed = maxSpeed * (Math.abs(speed)/speed);
        }
        setPosition(getPosition().add(GameMath.polarToVector(speed, getRotation() - (float)(Math.PI/2.0))));
    }
}
