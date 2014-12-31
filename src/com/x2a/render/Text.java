package com.x2a.render;

import com.x2a.math.Vector2;

import java.awt.*;

/**
 * Created by Ethan on 12/30/2014.
 */
public class Text implements Primitive {

    private String text;
    private Vector2 center;
    private float width;
    private float height;
    private float depth;
    private float rotation;

    private Color color;

    public Text(String text, Vector2 center, float width, float height, float rotation, Color color, float depth) {
        this.text = text;
        this.center = new Vector2(center);
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.rotation = rotation;

        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);

        float xTransform = getCenter().x;
        float yTransform = getCenter().y;

        float xTransform2 = -(getWidth()/2.0f);
        float yTransform2 = -(getHeight()/2.0f);

        g2.translate(xTransform, yTransform);
        g2.rotate(getRotation());
        g2.translate(xTransform2, yTransform2);

        g2.drawString(text, 0, 0);

        g2.translate(-xTransform2, -yTransform2);
        g2.rotate(getRotation());
        g2.translate(-xTransform, -yTransform);
    }

    @Override
    public float getDepth() {
        return 0;
    }

    public Vector2 getCenter() {
        return new Vector2(center);
    }

    public void setCenter(Vector2 center) {
        this.center = new Vector2(center);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
