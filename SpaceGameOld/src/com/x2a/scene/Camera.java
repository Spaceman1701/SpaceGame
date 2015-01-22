package com.x2a.scene;

import com.x2a.Application;
import com.x2a.math.AxisAlignedBox;
import com.x2a.math.GameMath;
import com.x2a.math.Vector2;

/**
 * Created by David on 12/28/2014.
 */
public class Camera extends Node{

    private static final float ARRIVAL_DISTANCE = 25.0f;
    private static final float ZOOM_EPSILON = 0.1f;
    private Vector2 position;
    private float scale;

    private boolean movingToTarget;
    private Vector2 target;
    private float moveSpeed;


    private boolean smoothZooming;
    private float zoomTarget;
    private float zoomSpeed;

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

    public void moveToTarget(Vector2 target, float speed) {
        this.target = target;
        this.moveSpeed = speed;
        movingToTarget = true;
    }

    @Override
    public void update(float timeElapsed) {
        if (movingToTarget && GameMath.getDistance(getPosition(), target) >= ARRIVAL_DISTANCE) {
            Vector2 direction = new Vector2(target).sub(getPosition());
            direction.unitVector();

            moveCameraPosition(new Vector2(direction).mult(moveSpeed));
        } else {
            movingToTarget = false;
        }
        if (smoothZooming && Math.abs(zoomTarget - getScale()) >= ZOOM_EPSILON) {
            setScale(getScale() + zoomSpeed);
        } else {
            smoothZooming = false;
        }
    }

    public void smoothZoom(float target, float speed) {
        this.zoomTarget = target;
        this.zoomSpeed = speed;
        this.smoothZooming = true;
    }
}
