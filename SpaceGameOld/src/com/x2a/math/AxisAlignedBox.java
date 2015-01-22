package com.x2a.math;

/**
 * Created by Ethan on 12/31/2014.
 */
public class AxisAlignedBox {
    private Vector2 topLeft;
    private Vector2 bottomRight;

    public AxisAlignedBox(Vector2 topLeft, Vector2 bottomRight) {
        this.topLeft = new Vector2(topLeft);
        this.bottomRight = new Vector2(bottomRight);
    }

    public AxisAlignedBox(Vector2 center, float width, float height) {
        topLeft = new Vector2(center).sub(new Vector2(width/2.0f, height/2.0f));
        bottomRight = new Vector2(center).add(new Vector2(width/2.0f, height/2.0f));
    }

    public boolean pointInside(Vector2 point) {
        return (point.x > topLeft.x && point.y > topLeft.y && point.x < bottomRight.x && point.y < bottomRight.y);
    }

    public Vector2 getTopLeft() {
        return new Vector2(topLeft);
    }

    public void setTopLeft(Vector2 topLeft) {
        this.topLeft = new Vector2(topLeft);
    }

    public Vector2 getBottomRight() {
        return new Vector2(bottomRight);
    }

    public void setBottomRight(Vector2 bottomRight) {
        this.bottomRight = new Vector2(bottomRight);
    }
}
