package com.x2a.scene;

import com.x2a.math.Vector2;

/**
 * Created by David on 12/28/2014.
 */
public class Camera {

    private Vector2 position;
    private float width;
    private float height;

    public Camera() {
        position = new Vector2();
    }

    public Camera(Vector2 position) {
        this.position = new Vector2(position);
    }

    public Camera(Vector2 position, float width, float height) {
        this.position = new Vector2(position);
        this.width = width;
        this.height = height;
    }

    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setCameraPosition(Vector2 position) {
        this.position = new Vector2(position);
    }

    public void moveCameraPosition(Vector2 translation) {
        position.add(translation);
    }

    public void setCameraSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void resizeCameraSize(float scale) {
        this.width *= scale;
        this.height *= scale;
    }
}
