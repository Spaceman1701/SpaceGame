package com.x2a.math;

/**
 * Created by David on 12/28/2014.
 */
public class Line {

    private Vector2 p; // A point that lies along the line
    private Vector2 v; // A unit vector in the direction of the line

    public Line() {
        this.p = new Vector2();
        this.v = new Vector2();
    }

    public Line(Vector2 p, Vector2 v) {
        this.p = new Vector2(p);
        this.v = new Vector2(v).unitVector();
    }

    public Line fromPoints(Vector2 p1, Vector2 p2) {
        this.p = new Vector2(p1);
        this.v = new Vector2(p2).sub(p1).unitVector();
        return this;
    }

    public Vector2 getPoint() {
        return new Vector2(p);
    }

    public Vector2 getDirection() {
        return new Vector2(v);
    }

    public Vector2 projectPoint(Vector2 p1) {
        return new Vector2(v).mult(p.dot(p1) / v.mag2());
    }

    public String toString() {
        return "{Line, " + p.toString() + ", " + v.toString() + "}";
    }
}
