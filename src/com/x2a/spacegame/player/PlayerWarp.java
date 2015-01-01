package com.x2a.spacegame.player;

import com.x2a.Application;
import com.x2a.input.KeyEventData;
import com.x2a.input.KeyEventType;
import com.x2a.input.MouseEventData;
import com.x2a.input.MouseEventType;
import com.x2a.math.GameMath;
import com.x2a.math.Vector2;
import com.x2a.scene.InputSprite;
import com.x2a.spacegame.Player;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Ethan on 12/29/2014.
 */
public class PlayerWarp extends InputSprite{

    private static final String IMAGE_LOCATION = "res/images/sprites/Spaceship.jpg";
    private static final float INITIAL_MAX_SPEED = 2f;


    private Vector2 target;
    private float maxSpeed;

    private boolean atTarget;

    private Player player;

    public PlayerWarp(Player player) {
        super(new Vector2(), 50, 50, 0, 0, IMAGE_LOCATION, "SPR_PLAYER_WARP");

        target = new Vector2(Application.X_RES/2 - 55, Application.Y_RES/2 - 55);
        maxSpeed = INITIAL_MAX_SPEED;

        this.player = player;
    }

    @Override
    public void onKeyEvent(KeyEventData data) {
        if (data.getEventType() == KeyEventType.KEY_PRESSED && data.getKeyCode() == KeyEvent.VK_SPACE) {
            stop();
        }
    }

    @Override
    public void onMouseEvent(MouseEventData data) {
        if (data.getMouseButton() == MouseEvent.BUTTON3 && data.getEventType() == MouseEventType.MOUSE_PRESSED) {
            if (atTarget) {
                target = new Vector2(data.getWorldPosition(player.getGame().getCurrentScene().getCamera()));
                Vector2 targetDirection = new Vector2(target).sub(getPosition());
                if (targetDirection.mag() != 0) {
                    targetDirection.unitVector();
                    System.out.println(targetDirection);

                    float theta = GameMath.signedAngle(targetDirection, GameMath.polarToVector(1, getRotation())) - (float) Math.PI / 2.0f;
                    System.out.println(Math.toDegrees(theta));
                    setRotation(-theta);
                }
            }
        }
    }

    public void stop() {
        target = new Vector2(getPosition());
    }


    @Override
    public void update(float timeElapsed) {
        Vector2 targetDirection = new Vector2(target).sub(getPosition());
        if (GameMath.getDistance(target, getPosition()) > 2f) {
            if (targetDirection.mag() != 0) {
                targetDirection.unitVector();
                setPosition(getPosition().add(new Vector2(targetDirection).mult(maxSpeed)));
                atTarget = false;
            }
        } else {
            setRotation(0);
            atTarget = true;
        }
    }
}
