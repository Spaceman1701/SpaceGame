package com.x2a.math;

import java.text.DecimalFormat;

/**
 * Created by David on 12/28/2014.
 */
public class Vector2 {

    private static final DecimalFormat df = new DecimalFormat("#.##");

    public float x;
    public float y;

    public Vector2() {
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 vector) {
        x = vector.x;
        y = vector.y;
    }

    public Vector2 add(Vector2 vector) {
        x += vector.x;
        y += vector.y;
        return this;
    }

    public Vector2 sub(Vector2 vector) {
        x -= vector.x;
        y -= vector.y;
        return this;
    }

    public Vector2 mult(float scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    public Vector2 div(float scalar) {
        x /= scalar;
        y /= scalar;
        return this;
    }

    public Vector2 unitVector() {
        float length = mag();
        this.x /= length;
        this.y /= length;
        return this;
    }

    public float mag() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float mag2() {
        return x * x + y * y;
    }

    public float dot(Vector2 vector) {
        return x * vector.x + y * vector.y;
    }

    @Override
    public String toString() {
        return "{Vector2, " + df.format(x) + ", " + df.format(y) + "}";
    }
}
