package com.x2a.spacegame;

import com.x2a.math.Vector2;
import com.x2a.scene.Sprite;

import java.util.Vector;

/**
 * Created by Ethan on 12/28/2014.
 */
public class TestSprite extends Sprite {


    public TestSprite(Vector2 position, String name, float depth) {
        super(position, 100, 100, 0, depth, "res/images/sprites/Test Sprite Image.png", name);
    }

    @Override
    public void update(float timeElapsed) {
        setRotation(getRotation() + (float)Math.toRadians(10));

        //System.out.println(getName() + "update called");
    }

    @Override
    public void draw() {
        super.draw();
       // System.out.println(getName() + "draw called");
    }
}
