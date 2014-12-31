package com.x2a.render;

import java.awt.*;

/**
 * Created by Ethan on 12/30/2014.
 */
public interface Primitive {
    public void draw(Graphics2D g2);

    public float getDepth();
}
