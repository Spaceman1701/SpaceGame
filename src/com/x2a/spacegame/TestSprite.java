package com.x2a.spacegame;

import com.x2a.input.InputUtil;
import com.x2a.input.KeyEventData;
import com.x2a.input.KeyEventListener;
import com.x2a.input.KeyEventType;
import com.x2a.math.Vector2;
import com.x2a.scene.Sprite;

import java.util.Vector;

/**
 * Created by Ethan on 12/28/2014.
 */
public class TestSprite extends Sprite {


    public TestSprite(Vector2 position, String name, float depth) {
        super(position, 300, 300, 0, depth, "res/images/sprites/Rotation Test.png", name);

        InputUtil.getInstance().registerKeyEventListener(new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
                if (data.getEventType() == KeyEventType.KEY_PRESSED) {
                    if (Character.toLowerCase(data.getKeyChar()) == 'r') {
                        setRotation(getRotation() + (float)Math.toRadians(10));
                    }
                }
            }
        });
    }

    @Override
    public void update(float timeElapsed) {

        //System.out.println(getName() + "update called");
    }

    @Override
    public void draw() {
        super.draw();
       // System.out.println(getName() + "draw called");
    }
}
