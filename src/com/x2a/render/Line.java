package com.x2a.render;

import com.x2a.math.Vector2;

import java.awt.*;

/**
 * Created by Ethan on 12/30/2014.
 */
public class Line implements Primitive {

    private Vector2 p1;
    private Vector2 p2;

    private float depth;

    private Color color;


    public Line(Vector2 p1, Vector2 p2, float depth, Color color) {
        this.p1 = new Vector2(p1);
        this.p2 = new Vector2(p2);

        this.depth = depth;

        this.color = color;
    }


    @Override
    public void doDraw(Graphics2D g2) {
        g2.setColor(color);
        g2.drawLine((int)p1.x, (int)p1.y, (int)p2.x, (int)p2.y);
    }

    @Override
    public float getDepth() {
        return 0;
    }
}
