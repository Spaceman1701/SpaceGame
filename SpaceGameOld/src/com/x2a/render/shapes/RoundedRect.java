package com.x2a.render.shapes;

import com.x2a.math.Vector2;
import com.x2a.render.Shape;

import java.awt.*;

/**
 * Created by Ethan on 12/30/2014.
 */
public class RoundedRect extends Shape{

    private int arcWidth;
    private int arcHeight;

    public RoundedRect(Vector2 center, float width, float height, int arcWidth, int arcHeight, float rotation, float depth, Color color, boolean fill) {
        super(center, width, height, rotation, depth, color, fill);

        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    @Override
    public void doShapeDraw(Graphics2D g2) {
        if (isFill()) {
            g2.fillRoundRect(0, 0, (int)getWidth(), (int)getHeight(), arcWidth, arcHeight);
        } else {
            g2.drawRoundRect(0, 0, (int)getWidth(), (int)getHeight(), arcWidth, arcHeight);
        }
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

}
