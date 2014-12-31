package com.x2a.spacegame.player;

import com.x2a.input.*;
import com.x2a.math.GameMath;
import com.x2a.math.Vector2;
import com.x2a.render.Line;
import com.x2a.render.Renderer;
import com.x2a.render.Text;
import com.x2a.render.shapes.Rectangle;
import com.x2a.scene.InputSprite;
import com.x2a.scene.Node;
import com.x2a.spacegame.Player;

import java.awt.*;

/**
 * Created by Ethan on 12/29/2014.
 */
public class PlayerSpace extends InputSprite {

    private static final String IMAGE_LOCATION = "res/images/sprites/Spaceship.jpg";

    private static final char FORWARD = 'w';
    private static final char BACKWARD = 's';
    private static final char LEFT = 'a';
    private static final char RIGHT = 'd';

    private float maxSpeed = 3;

    private float speed = 0;

    private final Player player;

    public PlayerSpace(Player player) {
        super(new Vector2(), 150, 150, 0, 1f, IMAGE_LOCATION, "SPR_PLAYER_SPACE", true);

        this.player = player;
    }

    @Override
    public void onKeyEvent(KeyEventData data) {

    }

    @Override
    public void onMouseEvent(MouseEventData data) {

    }

    @Override
    public void update(float timeElapsed) {
        super.update(timeElapsed);

        SafeInputUtil input = SafeInputUtil.getInstance();

        if (input.isKeyDown(FORWARD)) {
            speed += 0.11f;
        }
        if (input.isKeyDown(BACKWARD)) {
            speed -= 0.11f;
        }
        if (input.isKeyDown(LEFT)) {
            rotate(-0.05f);
        }
        if (input.isKeyDown(RIGHT)) {
            rotate(0.05f);
        }


        if (Math.abs(speed) > maxSpeed) {
            speed = maxSpeed * (Math.abs(speed)/speed);
        }
        setPosition(getPosition().add(GameMath.polarToVector(speed, getRotation() - (float)(Math.PI/2.0))));
        player.getGame().getCurrentScene().getCamera().setCameraPosition(getPosition());
    }

    @Override
    protected void onDeactivation() {
        player.getGame().getCurrentScene().getCamera().setCameraPosition(new Vector2());
    }
}
