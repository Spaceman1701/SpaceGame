package com.x2a.render.shapes;

import com.x2a.math.Vector2;
import com.x2a.render.Shape;

import java.awt.*;

/**
 * Created by Ethan on 12/30/2014.
 */
public class Elipse extends Shape {

    public Elipse(Vector2 center, float width, float height, float rotation, float depth, Color color, boolean fill) {
        super(center, width, height, rotation, depth, color, fill);
    }

    @Override
    public void doShapeDraw(Graphics2D g2) {
        if (isFill()) {
            g2.fillOval(0, 0, (int)getWidth(), (int)getHeight());
        } else {
            g2.drawOval(0, 0, (int)getWidth(), (int)getHeight());
        }
    }
}
