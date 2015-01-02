package com.x2a.math;

/**
 * Created by Ethan on 1/1/2015.
 */
public class BoundingCircle {

    private Vector2 position;
    private float radius;

    public BoundingCircle(Vector2 position, float radius) {
        this.position = new Vector2(position);
        this.radius = radius;
    }

    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public void setPosition(Vector2 position) {
        this.position = new Vector2(position);
    }

    public boolean pointInside(Vector2 point) {
        return GameMath.getDistance(point, getPosition()) < radius;
    }

    public boolean collidesWith(BoundingCircle bc) {
        return GameMath.getDistance(bc.getPosition(), getPosition()) < (radius + bc.radius);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
