package com.x2a.scene;

import com.x2a.Application;
import com.x2a.math.AxisAlignedBox;
import com.x2a.math.Vector2;

/**
 * Created by David on 12/28/2014.
 */
public class Camera {

    private Vector2 position;
    private float scale;

    public Camera() {
        position = new Vector2();
        scale = 1.0f;
    }

    public Camera(Vector2 position) {
        this.position = new Vector2(position);
        scale = 1.0f;
    }

    public Camera(Vector2 position, float scale) {
        this.position = new Vector2(position);
        this.scale = scale;
    }

    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public float getScale() {
        return scale;
    }

    public void setCameraPosition(Vector2 position) {
        this.position = new Vector2(position);
    }

    public void moveCameraPosition(Vector2 translation) {
        position.add(translation);
    }

    public void setScale(float scale) {
        if (scale <= 0) {
            return;
        }
        this.scale = scale;
    }

    public AxisAlignedBox getView() {
        float inverseScale = 1.0f/scale;
        float width = Application.X_RES/inverseScale;
        float height = Application.Y_RES/inverseScale;

        return new AxisAlignedBox(position, width, height);
    }
}
