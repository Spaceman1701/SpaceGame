package com.x2a.render;

import com.x2a.math.Vector2;

import java.awt.*;

/**
 * Created by Ethan on 12/30/2014.
 */
public abstract class Shape implements Primitive{
    private boolean fill;

    private float depth;

    private Vector2 center;



    private float width;
    private float height;

    private float rotation;

    private Color color;

    public Shape(Vector2 center, float width, float height, float rotation, float depth, Color color, boolean fill) {
        this.center = new Vector2(center);
        this.width = width;
        this.height = height;
        this.rotation = rotation;

        this.depth = depth;
        this.fill = fill;

        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);

        float xTransform = getCenter().x;// - (int)(spr.getWidth()/2.0f);
        float yTransform = getCenter().y;// - (int)(spr.getHeight()/2.0f);

        float xTransform2 = -(getWidth()/2.0f);
        float yTransform2 = -(getHeight()/2.0f);

        g2.translate(xTransform, yTransform);
        g2.rotate(getRotation());
        g2.translate(xTransform2, yTransform2);

        doShapeDraw(g2);

        g2.translate(-xTransform2, -yTransform2);
        g2.rotate(getRotation());
        g2.translate(-xTransform, -yTransform);
    }

    public abstract void doShapeDraw(Graphics2D g2);


    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public boolean isFill() {
        return fill;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getDepth() {
        return depth;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Vector2 getCenter() {
        return new Vector2(center);
    }

    public void setCenter(Vector2 center) {
        this.center = new Vector2(center);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
