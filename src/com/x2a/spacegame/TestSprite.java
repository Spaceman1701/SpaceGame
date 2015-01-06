package com.x2a.spacegame;

import com.x2a.input.*;
import com.x2a.math.Vector2;
import com.x2a.scene.InputSprite;
import com.x2a.scene.Sprite;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Ethan on 12/28/2014.
 */
public class TestSprite extends InputSprite {

    public TestSprite(Vector2 position, String name, float depth) {
        super(position, 300, 300, 0, depth, "res/images/sprites/Spaceship 2.png", name);
    }

    public TestSprite(Vector2 position, String name, float depth, BufferedImage image) {
        super(position, 700, 700, 0, depth, image, name);
    }

    @Override
    public void update(float timeElapsed) {

    }

    @Override
    public void draw() {
        super.draw();
       // System.out.println(getName() + "doDraw called");
    }

    @Override
    public void onKeyEvent(KeyEventData data) {
        if (data.getEventType() == KeyEventType.KEY_PRESSED) {
            if (Character.toLowerCase(data.getKeyChar()) == 'r') {
                setRotation(getRotation() + (float)Math.toRadians(10));
            }
        }
    }

    @Override
    public void onMouseEvent(MouseEventData data) {}
}
