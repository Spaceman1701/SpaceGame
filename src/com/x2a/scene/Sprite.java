package com.x2a.scene;

import com.x2a.math.Vector2;

import java.awt.*;

/**
 * Created by Ethan on 12/28/2014.
 */
public class Sprite {

    private float depth; //Higher depth = further from camera.

    private Vector2 position;

    private float height;
    private float width;

    private float rotation;

    private Image image;


    public float getDepth() {
        return depth;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }

    public Image getImage() {
        return image;
    }
}
